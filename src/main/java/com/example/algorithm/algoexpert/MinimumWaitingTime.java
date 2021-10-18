package com.example.algorithm.algoexpert;

import java.util.Arrays;

/**
 * algoexpert.io
 * 스스로 풀었음 : o
 * time complexity: O(1) (=number of queries)
* */
public class MinimumWaitingTime {
    public static void main(String[] args) {
        System.out.println(minimumWaitingTime(new int[]{1,4,5}));
    }

    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries); // 오름차순 정렬

        int currentWait = 0;
        int totalWait = 0;

        for (int i = 1; i < queries.length; i++) {
            currentWait +=queries[i-1];
            totalWait += currentWait;
        }
        return totalWait;
    }
}
