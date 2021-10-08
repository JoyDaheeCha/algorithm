package com.example.algorithm.boj.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1285 {
    private static int flipCnt = 0;
    private static String[][] coins;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        // 1. 코인 넣기
        coins = new String[n][n];

        for (int i = 0; i < n; i++) {
           coins[i] = br.readLine().split("");
        }

        // 2. T 갯수가 전체 길이의 1/2 이상인 경우 뒤집기.
        // 2.1 열(column)기준
        for (int i = 0; i < n; i++) {
            int tCnt = 0; // T 갯수
            for (int j = 0; j < n; j++) {
                if ("T".equals(coins[j][i])) {
                    tCnt++;
                }
            }
            if(tCnt > n/2) {
                flipColumn(i); // 열기준 뒤집기
                flipCnt++;
            }
        }

        // 2.2 행(row)기준
        for (int i = 0; i < n; i++) {
            int tCnt = 0; // T 갯수
            for (int j = 0; j < n; j++) {
                if ("T".equals(coins[i][j])) {
                    tCnt++;
                }
            }
            if(tCnt > n/2) {
                flipRow(i); // 열기준 뒤집기
                flipCnt++;
            }
        }

        System.out.println(flipCnt);
    }

    // cIdx: 컬럼 인덱스
    static void flipColumn(int cIdx) {
        for (int i = 0; i < n; i++) {
            if ("T".equals(coins[i][cIdx])) {
                coins[i][cIdx] = "H";
            } else {
                coins[i][cIdx] = "T";
            }
        }
    }

    // cIdx: 컬럼 인덱스
    static void flipRow(int cIdx) {
        for (int i = 0; i < n; i++) {
            if ("T".equals(coins[cIdx][i])) {
                coins[cIdx][i] = "H";
            } else {
                coins[cIdx][i] = "T";
            }
        }
    }
}
