package DataStructures.Linear;

import DataStructures.NonLinear.Heap;

public class PriorityQueueWithHeap {
    private int capacity;
    private final Heap heap = new Heap(capacity);

    public PriorityQueueWithHeap(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(int item) {
        heap.insert(item);
    }

    public int dequeue() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public boolean isFull() {
        return heap.isFull();
    }
}
