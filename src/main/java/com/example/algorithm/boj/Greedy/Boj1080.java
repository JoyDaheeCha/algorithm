package com.example.algorithm.boj.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 / 1080 / 행렬
 *
 * 솔루션: 뒤집을 수 있는 경우가 가장 적은 (0,0)부터 (N-3, N-3)까지 비교한다.
* */
public class Boj1080 {

    private static int[][] a;
    private static int[][] b;

    private static int n;
    private static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 행렬 가로 세로 길이
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 2. 행렬 초기화
        a = new int[n][m];
        b = new int[n][m];

        for (int i = 0; i < n; i++) {
            a[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n; i++) {
            b[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        // 3. 뒤집기
        int totalCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(a[i][j] != b[i][j]) {
                    if(flip(i,j)) {
                        totalCnt++;
                    }else{
                        System.out.println(-1); // 뒤집을 수 없을 때
                        return;
                    }
                }
            }
        }

        System.out.println(totalCnt);
    }

    private static boolean flip(int i, int j) {
        if(i + 3 > n || j + 3 > m) {
            return false;
        }

        for (int i1 = i; i1 < (i+3); i1++) {
            for (int j1 = j; j1 < (j+3); j1++) {
                a[i1][j1] = 1 - a[i1][j1];
            }
        }
        return true;
    }
}
