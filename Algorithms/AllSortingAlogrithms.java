package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllSortingAlogrithms {

    public static void bucketSort(int[] array, int numOfBuckets) {
        var i = 0;
        for (var bucket : createBuckets(array, numOfBuckets)) {
            Collections.sort(bucket);
            for (var item : bucket)
                array[i++] = item;
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            var minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            swap(array, minIndex, i);
        }
    }

    public static void bubbleSort(int[] array) {
        boolean isSorted;

        for (int i = 0; i < array.length; i++) {
            isSorted = true;

            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    isSorted = false;
                }
            }

            if (isSorted)
                return;
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            var current = array[i];

            var j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    public static void countingSort(int[] array, int maxVal) {
        int[] count = new int[maxVal + 1];

        for (var item : array)
            count[item]++;

        var k = 0;
        for (int i = 0; i < count.length; i++)
            for (int j = 0; j < count[i]; j++)
                array[k++] = i;
    }

    public static void mergeSort(int[] array) {
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

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end)
            return;

        var boundary = partition(array, start, end);

        quickSort(array, start, boundary - 1);
        quickSort(array, boundary + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        var pivot = array[end];
        var boundary = start - 1;

        for (int i = start; i <= end; i++)
            if (array[i] <= pivot)
                swap(array, i, ++boundary);

        return boundary;
    }

    private static void merge(int[] left, int[] right, int[] result) {
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

    private static List<List<Integer>> createBuckets(int[] array, int numOfBuckets) {
        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i < numOfBuckets; i++)
            buckets.add(new ArrayList<>());

        for (var item : array)
            buckets.get(item / numOfBuckets).add(item);

        return buckets;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
