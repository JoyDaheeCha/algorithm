package com.example.algorithm.boj.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 / Greedy / 11047: 동전 0
 *
 * 해결법: 가장 단위가 큰 화폐부터 지급
* */
public class Boj11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        final int moneyCateCnt = Integer.parseInt(input[0]); // 화폐 종류 K
        final int totalMoney = Integer.parseInt(input[1]); // 총 금액 N

        final int[] moneyCate = new int[moneyCateCnt];

        // 1. 화폐 단위 내림 차순으로 저장
        for (int i = moneyCateCnt - 1 ; i >= 0 ; i--) {
            moneyCate[i] = Integer.parseInt(br.readLine());
        }

        // 2. 큰 화폐 단위부터 가치 계산에 사용한다.
        int remaining = totalMoney; // 동전으로 환산되지 않은 금액
        int usedCoinTotalCnt = 0; // 사용된 동전 갯수

        for (int i = 0; i < moneyCate.length; i++) {
            if (moneyCate[i] <= remaining) {
                // 2.1 가치환산
                int coinCnt = remaining/moneyCate[i];
                remaining = remaining - coinCnt * moneyCate[i];
                // 2.2 사용된 동전 갯수 계산
                usedCoinTotalCnt += coinCnt;
            }
        }

        System.out.println(usedCoinTotalCnt);
    }
}
