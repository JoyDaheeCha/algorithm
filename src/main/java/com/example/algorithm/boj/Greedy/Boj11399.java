package com.example.algorithm.boj.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 사람 수
        int n = Integer.parseInt(br.readLine());

        // 2. ATM 이용시간 입력 받기
        String[] input = br.readLine().split(" ");
        int[] useT = new int[n];

        // 3. 이용시간 배열 만들기
        for (int i = 0; i < n; i++) {
            useT[i] = Integer.parseInt(input[i]);
        }

        // 4. 이용 시간 오름 차순 정렬
        int[] sorted = Arrays.stream(useT).sorted().toArray();

        // 5. 총 대기시간 계산
        int totalWaitingMin = 0;
        for (int i = 0; i < n; i++) {
            totalWaitingMin += sorted[i] * (n-i);
        }

        System.out.println(totalWaitingMin);
    }
}
