package DataStructures.Linear;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class PriorityQueue {
    private int[] items;
    private int count;

    public PriorityQueue(int capacity) {
        items = new int[capacity];
    }

    // add
    public void add(int item) {
        if (isFull())
            throw new IllegalStateException();

        var i = getPosition(item);
        items[i] = item;
        count++;
    }

    private int getPosition(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item)
                items[i + 1] = items[i];
            else
                break;
        }
        return i + 1;
    }

    // remove
    public int remove() {
        if (isEmpty())
            throw new NoSuchElementException();

        return items[--count];
    }

    // is empty
    private boolean isEmpty() {
        return count == 0;
    }

    // is full
    private boolean isFull() {
        return count == items.length;
    }

    // to string
    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
