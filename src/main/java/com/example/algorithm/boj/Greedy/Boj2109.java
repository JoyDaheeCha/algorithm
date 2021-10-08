package com.example.algorithm.boj.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] pd = new int[n][2]; // 가격, 일 순

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pd[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(pd, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return Integer.compare(o2[0],o1[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        }); // 일 오름 차순, 가격 내림 차순 정렬

        long totalIncome = 0;
        int curDay = 0;
        for (int i = 0; i < n; i++) {
            if(pd[i][1] > curDay) {
                curDay = pd[i][1];
                totalIncome += pd[i][0];
            }
        }
        System.out.println(totalIncome);
    }
}
