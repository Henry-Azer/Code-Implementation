package Algorithms;

public class AllSearchingAlgorithms {

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == target)
                return i;

        return -1;
    }

    public static int binarySearchIterative(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (right >= left) {
            int mid = (left + right) / 2;

            if (array[mid] == target)
                return mid;

            if (target > array[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    public static int jumpSearch(int[] array, int target) {
        int blockSize = (int) Math.sqrt(array.length);
        int start = 0;
        int next = blockSize;

        while (start < array.length && target > array[next - 1]) {
            start = next;
            next += blockSize;
            if (next > array.length)
                next = array.length;
        }

        for (int i = start; i < next; i++)
            if (array[i] == target)
                return i;

        return -1;
    }

    public static int exponentialSearch(int[] array, int target) {
        int bound = 1;
        while (bound < array.length && array[bound] < target)
            bound *= 2;

        int left = bound / 2;
        int right = Math.min(bound, array.length - 1);

        return binarySearchRecursive(array, target, left, right);
    }

    public static int ternarySearch(int[] array, int target) {
        return ternarySearch(array, target, 0, array.length - 1);
    }

    private static int ternarySearch(int[] array, int target, int left, int right) {
        int partitionSize = (right - left) / 3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        if (target == array[mid2])
            return mid2;

        if (target == array[mid1])
            return mid1;

        if (target > array[mid1])
            return ternarySearch(array, target, mid1 + 1, right);

        if (target < array[mid1])
            return ternarySearch(array, target, left, mid1 - 1);

        return ternarySearch(array, target, mid1 + 1, mid2 - 1);
    }

    public static int binarySearchRecursive(int[] array, int target) {
        return binarySearchRecursive(array, target, 0, array.length - 1);
    }

    private static int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (right < left)
            return -1;

        int mid = (left + right) / 2;

        if (array[mid] == target)
            return mid;

        if (target < array[mid])
            return binarySearchRecursive(array, target, left, mid - 1);

        return binarySearchRecursive(array, target, mid + 1, right);
    }
}
