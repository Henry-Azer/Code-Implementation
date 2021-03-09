package Algorithms;

public class CountingSort {

    public void countingSort(int[] array, int maxVal) {
        int[] count = new int[maxVal + 1];

        for (var item: array)
            count[item]++;

        var k = 0;
        for (int i = 0; i < count.length; i++)
            for (int j = 0; j < count[i]; j++)
                array[k++] = i;
    }
}
