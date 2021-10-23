package com.example.algorithm.nadongbin;

import java.util.Scanner;

public class Greedy3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] given = sc.next().toCharArray();

        char[] count = new char[2];

        for (int i = 1; i < given.length; i++) {
            if(given[i-1] != given[i]) {
                count[given[i-1]-48]++;
            }
        }
        count[given[given.length-1]-48]++; // 마지막 숫자 그룹 count 증가 (예. 0001101)

        System.out.println(Math.min(count[0], count[1]));
    }
}
