package com.DataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public void bucketSort(int[] array, int numOfBuckets) {
        var i = 0;
        for (var bucket : createBuckets(array, numOfBuckets)) {
            Collections.sort(bucket);
            for (var item : bucket)
                array[i++] = item;
        }
    }

    private List<List<Integer>> createBuckets(int[] array, int numOfBuckets) {
        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i < numOfBuckets; i++)
            buckets.add(new ArrayList<>());

        for (var item : array)
            buckets.get(item / numOfBuckets).add(item);

        return buckets;
    }
}
