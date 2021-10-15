package com.example.algorithm.codility.binarysearch;

import java.util.Arrays;
import java.util.Comparator;

public class NailingPlankAnswer {

    public static void main(String[] args) {
        int[] A = new int[]{1,4,5,8};
        int[] B = new int[]{4,5,9,10};
        int[] C = new int[]{4,6,7,10,2};


        System.out.println(solution(A, B, C));
    }

    public static int solution(int[] A, int[] B, int[] C) {
        int N = A.length;
        int M = C.length;
        int[][] sortedNails = new int[M][2];
        for (int i = 0; i < M; i++) {
            sortedNails[i][0] = C[i];
            sortedNails[i][1] = i;
        }
        Arrays.sort(sortedNails, Comparator.comparingInt((int[] x) -> x[0]));

        int res = 0;
        for (int i = 0; i < N; i++) {
            res = minIndex(A[i], B[i], sortedNails, res);
            if (res == -1)
                return -1;
        }
        return res+1; // 인덱스가 0일 경우 못 1개, 1일 경우 못 2개 의미.
    }

    public static int minIndex(int pStart, int pEnd, int[][] nails, int oldRes) {
        int beg = 0;
        int end = nails.length-1;
        int res=-1;
        while(beg<=end) {
            int middle= (beg + end) / 2;
            if (nails[middle][0] < pStart) {
                beg = middle+1;

            }else if(nails[middle][0] >pEnd) {
                end = middle -1;
            }
            else {
                end = middle-1;
                res = middle;
            }
        }
        if (res == -1 || nails[res][0] > pEnd)
            return -1;
        int min= nails[res][1];
        while(res < nails.length && nails[res][0] <= pEnd) {
            min = Math.min(min, nails[res][1]);
            if(min<=oldRes)
                return oldRes;
            res++;
        }

        return min;
    }

}
