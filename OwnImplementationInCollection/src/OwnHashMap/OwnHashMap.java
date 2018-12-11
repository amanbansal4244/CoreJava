package OwnHashMap;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


public class OwnHashMap<K,V> {

	static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

	static final int MAXIMUM_CAPACITY = 1 << 30;

	static final float DEFAULT_LOAD_FACTOR = 0.75f;

	static final Entry<?,?>[] EMPTY_TABLE = {};

	transient Entry<K,V>[] table = (Entry<K,V>[]) EMPTY_TABLE;

	transient int size;

	int threshold;

	final float loadFactor;

	transient int modCount;

	static final int ALTERNATIVE_HASHING_THRESHOLD_DEFAULT = Integer.MAX_VALUE;

	private static class Holder {

		static final int ALTERNATIVE_HASHING_THRESHOLD;

		static {
			String altThreshold = java.security.AccessController.doPrivileged(
					new sun.security.action.GetPropertyAction(
							"jdk.map.althashing.threshold"));

			int threshold;
			try {
				threshold = (null != altThreshold)
						? Integer.parseInt(altThreshold)
								: ALTERNATIVE_HASHING_THRESHOLD_DEFAULT;

						// disable alternative hashing if -1
						if (threshold == -1) {
							threshold = Integer.MAX_VALUE;
						}

						if (threshold < 0) {
							throw new IllegalArgumentException("value must be positive integer.");
						}
			} catch(IllegalArgumentException failed) {
				throw new Error("Illegal value for 'jdk.map.althashing.threshold'", failed);
			}

			ALTERNATIVE_HASHING_THRESHOLD = threshold;
		}
	}

	/**
	 * A randomizing value associated with this instance that is applied to
	 * hash code of keys to make hash collisions harder to find. If 0 then
	 * alternative hashing is disabled.
	 */
	transient int hashSeed = 0;

	public OwnHashMap(int initialCapacity, float loadFactor) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal initial capacity: " +
					initialCapacity);
	
		this.loadFactor = loadFactor;
		threshold = initialCapacity;
	}

	public OwnHashMap() {
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	
	private static int roundUpToPowerOf2(int number) {
		// assert number >= 0 : "number must be non-negative";
		return number >= MAXIMUM_CAPACITY
				? MAXIMUM_CAPACITY
						: (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1;
	}

	private void inflateTable(int toSize) {
		// Find a power of 2 >= toSize
		int capacity = roundUpToPowerOf2(toSize);

		threshold = (int) Math.min(capacity * loadFactor, MAXIMUM_CAPACITY + 1);
		table = new Entry[capacity];
		initHashSeedAsNeeded(capacity);
	}

	// internal utilities

	/**
	 * Initialization hook for subclasses. This method is called
	 * in all constructors and pseudo-constructors (clone, readObject)
	 * after HashMap has been initialized but before any entries have
	 * been inserted.  (In the absence of this method, readObject would
	 * require explicit knowledge of subclasses.)
	 */
	void init() {
	}

	/**
	 * Initialize the hashing mask value. We defer initialization until we
	 * really need it.
	 */
	final boolean initHashSeedAsNeeded(int capacity) {
		boolean currentAltHashing = hashSeed != 0;
		boolean useAltHashing = sun.misc.VM.isBooted() &&
				(capacity >= Holder.ALTERNATIVE_HASHING_THRESHOLD);
		boolean switching = currentAltHashing ^ useAltHashing;
		/* if (switching) {
            hashSeed = useAltHashing
                ? sun.misc.Hashing.randomHashSeed(this)
                : 0;
        }*/
		return switching;
	}

	/**
	 * Retrieve object hash code and applies a supplemental hash function to the
	 * result hash, which defends against poor quality hash functions.  This is
	 * critical because HashMap uses power-of-two length hash tables, that
	 * otherwise encounter collisions for hashCodes that do not differ
	 * in lower bits. Note: Null keys always map to hash 0, thus index 0.
	 */
	final int hash(Object k) {
		int h = hashSeed;
		/* if (0 != h && k instanceof String) {
            return sun.misc.Hashing.stringHash32((String) k);
        }*/

		h ^= k.hashCode();

		// This function ensures that hashCodes that differ only by
		// constant multiples at each bit position have a bounded
		// number of collisions (approximately 8 at default load factor).
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	/**
	 * Returns index for hash code h.
	 */
	static int indexFor(int h, int length) {
		// assert Integer.bitCount(length) == 1 : "length must be a non-zero power of 2";
		return h & (length-1);
	}

	/**
	 * Returns the number of key-value mappings in this map.
	 *
	 * @return the number of key-value mappings in this map
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns <tt>true</tt> if this map contains no key-value mappings.
	 *
	 * @return <tt>true</tt> if this map contains no key-value mappings
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns the value to which the specified key is mapped,
	 * or {@code null} if this map contains no mapping for the key.
	 *
	 * <p>More formally, if this map contains a mapping from a key
	 * {@code k} to a value {@code v} such that {@code (key==null ? k==null :
	 * key.equals(k))}, then this method returns {@code v}; otherwise
	 * it returns {@code null}.  (There can be at most one such mapping.)
	 *
	 * <p>A return value of {@code null} does not <i>necessarily</i>
	 * indicate that the map contains no mapping for the key; it's also
	 * possible that the map explicitly maps the key to {@code null}.
	 * The {@link #containsKey containsKey} operation may be used to
	 * distinguish these two cases.
	 *
	 * @see #put(Object, Object)
	 */
	public V get(Object key) {
		if (key == null)
			return getForNullKey();
		Entry<K,V> entry = getEntry(key);

		return null == entry ? null : entry.getValue();
	}

	/**
	 * Offloaded version of get() to look up null keys.  Null keys map
	 * to index 0.  This null case is split out into separate methods
	 * for the sake of performance in the two most commonly used
	 * operations (get and put), but incorporated with conditionals in
	 * others.
	 */
	private V getForNullKey() {
		if (size == 0) {
			return null;
		}
		for (Entry<K,V> e = table[0]; e != null; e = e.next) {
			if (e.key == null)
				return e.value;
		}
		return null;
	}

	/**
	 * Returns <tt>true</tt> if this map contains a mapping for the
	 * specified key.
	 *
	 * @param   key   The key whose presence in this map is to be tested
	 * @return <tt>true</tt> if this map contains a mapping for the specified
	 * key.
	 */
	public boolean containsKey(Object key) {
		return getEntry(key) != null;
	}

	/**
	 * Returns the entry associated with the specified key in the
	 * HashMap.  Returns null if the HashMap contains no mapping
	 * for the key.
	 */
	final Entry<K,V> getEntry(Object key) {
		if (size == 0) {
			return null;
		}

		int hash = (key == null) ? 0 : hash(key);
		for (Entry<K,V> e = table[indexFor(hash, table.length)];
				e != null;
				e = e.next) {
			Object k;
			if (e.hash == hash &&
					((k = e.key) == key || (key != null && key.equals(k))))
				return e;
		}
		return null;
	}

	public V put(K key, V value) {
		if (table == EMPTY_TABLE) {
			inflateTable(threshold);
		}
		if (key == null)
			return putForNullKey(value);
		int hash = hash(key);
		int i = indexFor(hash, table.length);
		for (Entry<K,V> e = table[i]; e != null; e = e.next) {
			Object k;
			if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
				V oldValue = e.value;
				e.value = value;
				e.recordAccess(this);
				return oldValue;
			}
		}

		modCount++;
		addEntry(hash, key, value, i);
		return null;
	}

	/**
	 * Offloaded version of put for null keys
	 */
	private V putForNullKey(V value) {
		for (Entry<K,V> e = table[0]; e != null; e = e.next) {
			if (e.key == null) {
				V oldValue = e.value;
				e.value = value;
				e.recordAccess(this);
				return oldValue;
			}
		}
		modCount++;
		addEntry(0, null, value, 0);
		return null;
	}

	/**
	 * This method is used instead of put by constructors and
	 * pseudoconstructors (clone, readObject).  It does not resize the table,
	 * check for comodification, etc.  It calls createEntry rather than
	 * addEntry.
	 */
	private void putForCreate(K key, V value) {
		int hash = null == key ? 0 : hash(key);
		int i = indexFor(hash, table.length);

		/**
		 * Look for preexisting entry for key.  This will never happen for
		 * clone or deserialize.  It will only happen for construction if the
		 * input Map is a sorted map whose ordering is inconsistent w/ equals.
		 */
		for (Entry<K,V> e = table[i]; e != null; e = e.next) {
			Object k;
			if (e.hash == hash &&
					((k = e.key) == key || (key != null && key.equals(k)))) {
				e.value = value;
				return;
			}
		}

		createEntry(hash, key, value, i);
	}

	private void putAllForCreate(Map<? extends K, ? extends V> m) {
		for (Map.Entry<? extends K, ? extends V> e : m.entrySet())
			putForCreate(e.getKey(), e.getValue());
	}

	/**
	 * Rehashes the contents of this map into a new array with a
	 * larger capacity.  This method is called automatically when the
	 * number of keys in this map reaches its threshold.
	 *
	 * If current capacity is MAXIMUM_CAPACITY, this method does not
	 * resize the map, but sets threshold to Integer.MAX_VALUE.
	 * This has the effect of preventing future calls.
	 *
	 * @param newCapacity the new capacity, MUST be a power of two;
	 *        must be greater than current capacity unless current
	 *        capacity is MAXIMUM_CAPACITY (in which case value
	 *        is irrelevant).
	 */
	void resize(int newCapacity) {
		Entry[] oldTable = table;
		int oldCapacity = oldTable.length;
		if (oldCapacity == MAXIMUM_CAPACITY) {
			threshold = Integer.MAX_VALUE;
			return;
		}

		Entry[] newTable = new Entry[newCapacity];
		transfer(newTable, initHashSeedAsNeeded(newCapacity));
		table = newTable;
		threshold = (int)Math.min(newCapacity * loadFactor, MAXIMUM_CAPACITY + 1);
	}

	/**
	 * Transfers all entries from current table to newTable.
	 */
	void transfer(Entry[] newTable, boolean rehash) {
		int newCapacity = newTable.length;
		for (Entry<K,V> e : table) {
			while(null != e) {
				Entry<K,V> next = e.next;
				if (rehash) {
					e.hash = null == e.key ? 0 : hash(e.key);
				}
				int i = indexFor(e.hash, newCapacity);
				e.next = newTable[i];
				newTable[i] = e;
				e = next;
			}
		}
	}

	/**
	 * Copies all of the mappings from the specified map to this map.
	 * These mappings will replace any mappings that this map had for
	 * any of the keys currently in the specified map.
	 *
	 * @param m mappings to be stored in this map
	 * @throws NullPointerException if the specified map is null
	 */
	public void putAll(Map<? extends K, ? extends V> m) {
		int numKeysToBeAdded = m.size();
		if (numKeysToBeAdded == 0)
			return;

		if (table == EMPTY_TABLE) {
			inflateTable((int) Math.max(numKeysToBeAdded * loadFactor, threshold));
		}

		/*
		 * Expand the map if the map if the number of mappings to be added
		 * is greater than or equal to threshold.  This is conservative; the
		 * obvious condition is (m.size() + size) >= threshold, but this
		 * condition could result in a map with twice the appropriate capacity,
		 * if the keys to be added overlap with the keys already in this map.
		 * By using the conservative calculation, we subject ourself
		 * to at most one extra resize.
		 */
		if (numKeysToBeAdded > threshold) {
			int targetCapacity = (int)(numKeysToBeAdded / loadFactor + 1);
			if (targetCapacity > MAXIMUM_CAPACITY)
				targetCapacity = MAXIMUM_CAPACITY;
			int newCapacity = table.length;
			while (newCapacity < targetCapacity)
				newCapacity <<= 1;
			if (newCapacity > table.length)
				resize(newCapacity);
		}

		for (Map.Entry<? extends K, ? extends V> e : m.entrySet())
			put(e.getKey(), e.getValue());
	}

	/**
	 * Removes the mapping for the specified key from this map if present.
	 *
	 * @param  key key whose mapping is to be removed from the map
	 * @return the previous value associated with <tt>key</tt>, or
	 *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
	 *         (A <tt>null</tt> return can also indicate that the map
	 *         previously associated <tt>null</tt> with <tt>key</tt>.)
	 */
	public V remove(Object key) {
		Entry<K,V> e = removeEntryForKey(key);
		return (e == null ? null : e.value);
	}

	/**
	 * Removes and returns the entry associated with the specified key
	 * in the HashMap.  Returns null if the HashMap contains no mapping
	 * for this key.
	 */
	final Entry<K,V> removeEntryForKey(Object key) {
		if (size == 0) {
			return null;
		}
		int hash = (key == null) ? 0 : hash(key);
		int i = indexFor(hash, table.length);
		Entry<K,V> prev = table[i];
		Entry<K,V> e = prev;

		while (e != null) {
			Entry<K,V> next = e.next;
			Object k;
			if (e.hash == hash &&
					((k = e.key) == key || (key != null && key.equals(k)))) {
				modCount++;
				size--;
				if (prev == e)
					table[i] = next;
				else
					prev.next = next;
				e.recordRemoval(this);
				return e;
			}
			prev = e;
			e = next;
		}

		return e;
	}

	/**
	 * Special version of remove for EntrySet using {@code Map.Entry.equals()}
	 * for matching.
	 */
	final Entry<K,V> removeMapping(Object o) {
		if (size == 0 || !(o instanceof Map.Entry))
			return null;

		Map.Entry<K,V> entry = (Map.Entry<K,V>) o;
		Object key = entry.getKey();
		int hash = (key == null) ? 0 : hash(key);
		int i = indexFor(hash, table.length);
		Entry<K,V> prev = table[i];
		Entry<K,V> e = prev;

		while (e != null) {
			Entry<K,V> next = e.next;
			if (e.hash == hash && e.equals(entry)) {
				modCount++;
				size--;
				if (prev == e)
					table[i] = next;
				else
					prev.next = next;
				e.recordRemoval(this);
				return e;
			}
			prev = e;
			e = next;
		}

		return e;
	}

	/**
	 * Removes all of the mappings from this map.
	 * The map will be empty after this call returns.
	 */
	public void clear() {
		modCount++;
		Arrays.fill(table, null);
		size = 0;
	}

	/**
	 * Returns <tt>true</tt> if this map maps one or more keys to the
	 * specified value.
	 *
	 * @param value value whose presence in this map is to be tested
	 * @return <tt>true</tt> if this map maps one or more keys to the
	 *         specified value
	 */
	public boolean containsValue(Object value) {
		if (value == null)
			return containsNullValue();

		Entry[] tab = table;
		for (int i = 0; i < tab.length ; i++)
			for (Entry e = tab[i] ; e != null ; e = e.next)
				if (value.equals(e.value))
					return true;
		return false;
	}

	/**
	 * Special-case code for containsValue with null argument
	 */
	private boolean containsNullValue() {
		Entry[] tab = table;
		for (int i = 0; i < tab.length ; i++)
			for (Entry e = tab[i] ; e != null ; e = e.next)
				if (e.value == null)
					return true;
		return false;
	}


	static class Entry<K,V> implements Map.Entry<K,V> {
		final K key;
		V value;
		Entry<K,V> next;
		int hash;

		Entry(int h, K k, V v, Entry<K,V> n) {
			value = v;
			next = n;
			key = k;
			hash = h;
		}

		public final K getKey() {
			return key;
		}

		public final V getValue() {
			return value;
		}

		public final V setValue(V newValue) {
			V oldValue = value;
			value = newValue;
			return oldValue;
		}

		public final boolean equals(Object o) {
			if (!(o instanceof Map.Entry))
				return false;
			Map.Entry e = (Map.Entry)o;
			Object k1 = getKey();
			Object k2 = e.getKey();
			if (k1 == k2 || (k1 != null && k1.equals(k2))) {
				Object v1 = getValue();
				Object v2 = e.getValue();
				if (v1 == v2 || (v1 != null && v1.equals(v2)))
					return true;
			}
			return false;
		}

		public final int hashCode() {
			return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
		}

		public final String toString() {
			return getKey() + "=" + getValue();
		}

		/**
		 * This method is invoked whenever the value in an entry is
		 * overwritten by an invocation of put(k,v) for a key k that's already
		 * in the HashMap.
		 */
		void recordAccess(OwnHashMap<K, V> ownHashMap) {
		}

		/**
		 * This method is invoked whenever the entry is
		 * removed from the table.
		 */
		void recordRemoval(OwnHashMap<K, V> ownHashMap) {
		}
	}

	/**
	 * Adds a new entry with the specified key, value and hash code to
	 * the specified bucket.  It is the responsibility of this
	 * method to resize the table if appropriate.
	 *
	 * Subclass overrides this to alter the behavior of put method.
	 */
	void addEntry(int hash, K key, V value, int bucketIndex) {
		if ((size >= threshold) && (null != table[bucketIndex])) {
			resize(2 * table.length);
			hash = (null != key) ? hash(key) : 0;
			bucketIndex = indexFor(hash, table.length);
		}

		createEntry(hash, key, value, bucketIndex);
	}

	/**
	 * Like addEntry except that this version is used when creating entries
	 * as part of Map construction or "pseudo-construction" (cloning,
	 * deserialization).  This version needn't worry about resizing the table.
	 *
	 * Subclass overrides this to alter the behavior of HashMap(Map),
	 * clone, and readObject.
	 */
	void createEntry(int hash, K key, V value, int bucketIndex) {
		Entry<K,V> e = table[bucketIndex];
		table[bucketIndex] = new Entry<>(hash, key, value, e);
		size++;
	}

	// Views

	private transient Set<Map.Entry<K,V>> entrySet = null;
	
	// These methods are used when serializing HashSets
	int   capacity()     { return table.length; }
	float loadFactor()   { return loadFactor;   }

}
