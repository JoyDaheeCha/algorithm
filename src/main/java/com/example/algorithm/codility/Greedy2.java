package com.example.algorithm.codility;

/**
 * Codility / Greedy / TieRopes
 *
 * 문제 URL: https://app.codility.com/programmers/lessons/16-greedy_algorithms/
 *
 * 접근 방법: 앞에서부터 차례로 묶는다. (K가 될 때까지)
* */
public class Greedy2 {
    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{1, 2, 3, 4, 1, 1, 3}));
    }

    public static int solution(int K, int[] A) {
        int ropeCnt = 0;
        int curLength = 0;

        for (int rope : A) {
            curLength += rope;

            if(curLength >= K) {
                ropeCnt++;
                curLength = 0;
            }
        }
        return ropeCnt;
    }
}