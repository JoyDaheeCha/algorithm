package com.example.algorithm.goorm;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
* 구현 / 놀이공원
 * url: https://level.goorm.io/exam/88520/%EB%86%80%EC%9D%B4%EA%B3%B5%EC%9B%90/quiz/1
 *
 * [입력]
 * 1
 * 5 3
 * 1 0 0 1 0
 * 0 1 0 0 1
 * 0 0 0 1 0
 * 0 0 0 0 0
 * 0 0 1 0 0
 *
 * [출력]
 * 1
* */
public class Quiz88520 {
    public static final Scanner scanner = new Scanner(System.in);

    public static void testCase(int caseIndex) {
        int N = scanner.nextInt();  // 지도의 크기
        int K = scanner.nextInt();  // 놀이공원의 크기

        int[][] wastes = new int[N][N]; // 각 칸의 쓰레기 존재 여부
        for (int r = 0; r < N; r += 1) {
            for (int c = 0; c < N; c += 1) {
                wastes[r][c] = scanner.nextInt();
            }
        }

        int min = Integer.MAX_VALUE;;
        for (int r = 0; r <= N-K; r += 1) {
            for (int c = 0; c <= N-K; c += 1) {
                int wasteCnt = 0;
                for(int h = r; h < r+K; h++) {
                    for(int w = c; w < c+K; w++) {
                        if(wastes[h][w] == 1) {
                            wasteCnt++;
                        }
                    }
                }
                min = Math.min(wasteCnt, min);
            }
        }

        System.out.println(min);
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }

    }
}
