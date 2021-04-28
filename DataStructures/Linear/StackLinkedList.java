package DataStructures.Linear;

import java.util.LinkedList;

public class StackLinkedList {
    private LinkedList<Integer> list = new LinkedList<>();
    private int count = 0;

    public void push(int item) {
        list.addLast(item);
        count++;
    }

    public int pop() {
        if (count == 0)
            throw new IllegalStateException();

        count--;
        return list.removeLast();
    }

    public int peek() {
        if (count == 0)
            throw new IllegalStateException();

        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
