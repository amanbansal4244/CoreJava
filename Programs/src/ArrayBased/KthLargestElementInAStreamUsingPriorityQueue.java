package ArrayBased;

import java.util.PriorityQueue;
/*****
 * An Efficient Solution is to use Min Heap of size k to store k largest elements of stream. 
 * The k’th largest element is always at root and can be found in O(1) time.
 * 
 * How to process a new element of stream?
 * 				Compare the new element with root of heap. If new element is smaller, then ignore it. 
 * 				Otherwise replace root with new element and call heapify for the root of modified heap.
 * 			    Time complexity of finding the k’th largest element is O(Log(k)), where k is given number.
 * 
 * Java minHeap solution:
 * 			When questions ask Kth largest/smallest we don't really need to care about the order of those k elements, 
 * 			minHeap and maxHeap are useful for this kind of problem or even question about top k.
 * 		
 * 			Always keep minHeap size as K. When the heap size is greater than K, poll the head of the queue, 
 * 			So the head of the queue is the Kth largest number.
 */
class KthLargestElementInAStreamUsingPriorityQueue {
	/****
	 * PriorityQueue is an unbounded queue based on a priority heap and the elements of the priority queue are ordered 
	 * by default in natural order. We can provide a Comparator for ordering at the time of instantiation of priority queue.
	 */
	PriorityQueue<Integer> priorityQueue;
	int k;

	public KthLargestElementInAStreamUsingPriorityQueue(int k, int[] nums) {
		this.k = k;
		priorityQueue = new PriorityQueue<>(k);// We are creating PriorityQueue of size 'K'.
		for (int num : nums) {
			priorityQueue.offer(num);//Inserts the specified element into this priority queue.
			if (priorityQueue.size() > k) {
				priorityQueue.poll(); //Retrieves and removes the head of this queue, or returns null if this queue is empty.
			}
		}
	}

	public int add(int val) {
		priorityQueue.offer(val);//Inserts the specified element into this priority queue.
		if (priorityQueue.size() > k){
			priorityQueue.poll();//Retrieves and removes the head of this queue, or returns null if this queue is empty.
		}
		return priorityQueue.peek();//Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
	}
}