package com.example.algorithm.nadongbin;

import java.util.Scanner;

/**
 * 곱하기 혹은 더하기 (그리디 2번)
* */
public class Greedy2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] givens = sc.next().split("");

        int sum = 0;
        for(String given: givens) {
            int current = Integer.parseInt(given);

            if(sum == 0) {
                sum += current;
            } else {
                sum *= current;
            }
        }

        System.out.println(sum);
    }
}
