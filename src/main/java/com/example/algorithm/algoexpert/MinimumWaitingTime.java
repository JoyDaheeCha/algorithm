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

        int totalWait = 0;

        int queriesLen = queries.length;
        for (int i = 1; i < queriesLen; i++) {
            totalWait += queries[i-1] * (queriesLen - i);
        }
        return totalWait;
    }
}
