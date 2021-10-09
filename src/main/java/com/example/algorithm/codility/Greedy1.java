package com.example.algorithm.codility;

/**
 * Codility / Greedy / MaxNonoverlappingSegments
 *
 * 문제 URL: https://app.codility.com/programmers/lessons/16-greedy_algorithms/
 *
 * 접근 방법: B[i]가 작은 값부터 고려한다.
 * */

public class Greedy1 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution(new int[]{1, 3, 7, 9, 9}, new int[]{5, 6, 8, 9, 10})); // 3;
    }
}

class Solution {
    public int solution(int[] A, int[] B) {

        int[] latest = new int[]{-2, -1}; // 가장 최근에 포함된 요소

        int segCnt = 0;
        for (int i = 0; i < A.length; i++) {
            // 조건을 충족할 경우 카운트
            if(A[i] > latest[1]) {
                latest[0] = A[i];
                latest[1] = B[i];
                segCnt++;
            }
        }

        return segCnt;
    }
}