//Here's an example of a an ArrayList like class implementing the interface, in which you override the method Iterator().


import java.util.Iterator;

public class ImplementOwnIterator<Type> implements Iterable<Type> {

    private Type[] arrayList;
    private int currentSize;

    public ImplementOwnIterator(Type[] newArray) {
        this.arrayList = newArray;
        this.currentSize = arrayList.length;
    }

    @Override
    public Iterator<Type> iterator() {
        Iterator<Type> it = new Iterator<Type>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() { //this method should returns true or false.
                return currentIndex < currentSize && arrayList[currentIndex] != null;
            }

            @Override
            public Type next() { // this method should return value if present in array.
                return arrayList[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}