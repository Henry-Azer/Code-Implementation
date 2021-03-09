package Algorithms;

public class MergeSort {

    public void mergeSort(int[] array) {
        if (array.length < 2)
            return;

        int mid = array.length / 2;

        int[] left = new int[mid];
        System.arraycopy(array, 0, left, 0, mid);

        int[] right = new int[array.length - mid];
        if (array.length - mid >= 0)
            System.arraycopy(array, mid, right, 0, array.length - mid);

        mergeSort(left);
        mergeSort(right);

        merge(left, right, array);
    }

    private void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];

        }

        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];
    }
}