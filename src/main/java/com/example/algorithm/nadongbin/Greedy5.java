package com.example.algorithm.nadongbin;

import java.util.Scanner;

/**
 * 이코테/greedy5/볼링공 고르기
* */
public class Greedy5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] weight = new int[m+1]; // 1~m까지 사용

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            weight[x] += 1;
        }

        int result = 0;

        for (int i = 0; i < m; i++) {
            n -= weight[i];
            result += n * weight[i];
        }

        System.out.println(result);
    }
}
