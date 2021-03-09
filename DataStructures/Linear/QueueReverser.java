package DataStructure.Linear;

import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    public QueueReverser(Queue<Integer> queue, int k) {
        if (k < 0 || k > queue.size())
            throw new IllegalArgumentException();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++)
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());
    }
}
