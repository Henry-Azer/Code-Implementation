package DataStructures.NonLinear;

public class MaxHeap {
    public static int[] heapify(int[] array) {
        var lastParentIndex = array.length / 2 - 1;
        for (var i = lastParentIndex; i >= 0; i--) {
            heapify(array, i);
        }
        return array;
    }

    private static void heapify(int[] array, int index) {
        var largeIndex = index;

        var leftIndex = index * 2 + 1;
        if (leftIndex < array.length && array[leftIndex] > array[largeIndex])
            largeIndex = leftIndex;

        var rightIndex = index * 2 + 2;
        if (rightIndex < array.length && array[rightIndex] > array[largeIndex])
            largeIndex = rightIndex;

        if (index == largeIndex)
            return;

        swap(array, largeIndex, index);
        heapify(array, largeIndex);
    }

    private static void swap(int[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int getKthLargest(int[] array, int k) {
        if (k < 1 || k > array.length)
            throw new IllegalArgumentException();

        var heap = new Heap(array.length);
        for (int item : array)
            heap.insert(item);

        for (int i = 0; i < k - 1; i++)
            heap.remove();

        return heap.max();
    }
}
