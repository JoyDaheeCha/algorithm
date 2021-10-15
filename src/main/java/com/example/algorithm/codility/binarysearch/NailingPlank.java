package com.example.algorithm.codility.binarysearch;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 요구사항: 모든 plank를 못 박기 위한 nail idx 최솟값 찾기
* */
public class NailingPlank {
    public static void main(String[] args) {
        int[] A = new int[]{1,4,5,8};
        int[] B = new int[]{4,5,9,10};
        int[] C = new int[]{4,6,7,10,2};
        System.out.println(solution(A, B, C)); // 기대값 6
    }

    public static int solution(int[] A, int[] B, int[] C) {
        // A, B, C는 비지 않았다.

        int[][] nails = new int[C.length][2];
        for (int i = 0; i < C.length; i++) {
            nails[i][0] = C[i]; // 못 위치
            nails[i][1] = i; // 못 위치의 idx
        }

        // 못 위치 기준 오름 차순 정렬
        Arrays.sort(nails, Comparator.comparingInt(o -> o[0]));

        int min = 0;
        // plank 별로 못질 가능여부 확인 -> 가능하다면 이전 plank와 비교하여 nail idx의 최솟값 찾기
        for (int i = 0; i < A.length; i++) {
            min = nailMaxIdx(A[i], B[i], nails, min);
            if(min == -1) {
                return -1;
            }
        }
        return min + 1;
    }

    // 한 plank에서 nail의
    public static int nailMaxIdx(int startP, int endP, int[][] nails, int prevMin) {
        int beg = 0;
        int end = nails.length - 1;

        int res = -1;
        while(beg <= end) {
            int mid = (beg + end) / 2;

            if(nails[mid][0] > endP) {
                end = mid - 1;
            }else if(nails[mid][1] < startP) {
                beg = mid + 1;
            } else {
                end = mid - 1;
                res = mid;
            }
        }

        if (res == -1) {
            return -1;
        }

        int min = nails[res][1];
        while(res < nails.length && nails[res][0] <= endP) {
            min = Math.min(nails[res][1], min);
            if(min <= prevMin) {
                return prevMin;
            }
            min++;
        }

        return min;
    }
}
