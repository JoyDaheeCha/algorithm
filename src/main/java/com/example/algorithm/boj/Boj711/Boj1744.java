package com.example.algorithm.boj.Boj711;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 백준 1744 / 수 묶기
 *
 * 1. return은 프로그램 종료고, break는 while문 탈출임! 이런 기초적인 실수는 하지말자.
 * 2. 양수는 큰 수 끼리 묶을수록 이득이지만, 음수는 작은 수끼리 묶을 수록 이득이다.
* */
public class Boj1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean hasZero = false;
        int n = sc.nextInt();

        // 1. 배열 값 정렬
        PriorityQueue<Integer> positive = new PriorityQueue<>((x,y) -> Integer.compare(y,x)); // 내림 차순 정렬 e.g. 3,2,1
        PriorityQueue<Integer> negative = new PriorityQueue<>(); // 오름 차순 정렬 -3,-2,-1

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            if (number > 0) {
                positive.add(number);
            } else if (number == 0) {
                hasZero = true;
            } else {
                negative.add(number);
            }
        }

        //2. 양수 값 덧셈 (묶거나 묶지 않거나)
        int posSum = 0; // 양의 정수 계산 값
        while(!positive.isEmpty()) {
            int current = positive.poll();

            if(positive.peek() == null) {
                posSum += current; // 뒤 elment가 없으면 본인만 더한다.
            } else {
                posSum = current * positive.poll(); // 뒤 엘리먼트와 본인을 곱한 후, 더한다.
            }
        }

        //3. 음수 값 덧셈 (묶거나 묶지 않거나)
        int negSum = 0;
        while(!negative.isEmpty()) {
            int current = negative.poll();

            if(negative.peek() == null) {
                if(!hasZero) {
                    negSum += current; // 0을 가진 경우, 0과 곱하여 없앨 수 있다.
                }
            } else {
                negSum = current * negative.poll();
            }
        }

        System.out.println(posSum + negSum);
    }
}
