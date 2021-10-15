package com.example.algorithm.codility;

/**
 * 최댓값의 범위를 정의 후, logN으로 범위를 좁혀나가며 푼다. 
* */
public class BinarySearch {

    public static void main(String[] args) {
        int[] A = new int[]{2,1,5,1,2,2,2};
        int[] B = new int[]{3, 5, 2, 1, 5, 1, 2, 2, 2};
        int M = 5;
        int K = 3;
        System.out.println(solution(K, M, A));
    }

    public static int solution(int K, int M, int[] A) {
        // 0. 답의 범위
        int l = 0;
        int r = M * A.length;

        // 1. 답의 최대 값은 K가 1이고 모든 엘리먼트가 M일 때.
        int ans = M * A.length;

        while(l <= r) {
            int mid = (r + l) / 2;
            int sum = 0;
            int numGroup = 1;
            int maxSum = 0;
            for (int i = 0; i < A.length; i++) {
                // 만약 현재 그룹합이 mid를 넘어갈 경우 -> 새로운 그룹 추가
                if (sum + A[i] > mid) {
                    maxSum = Math.max(sum, maxSum);
                    sum = A[i];
                    numGroup++;
                } else {
                    sum += A[i];
                }
            }
            maxSum = Math.max(sum, maxSum);
            if (numGroup > K) {
                l = mid + 1;
            } else {
                ans = Math.min(maxSum, ans);
                r = mid - 1;
            }

        }
        return ans;
    }
}
