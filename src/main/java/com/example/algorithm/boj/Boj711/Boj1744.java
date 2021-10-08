package com.example.algorithm.boj.Boj711;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 백준 1744 / 수 묶기
 *
 * return은 프로그램 종료고, break는 while문 탈출임! 이런 기초적인 실수는 하지말자.
* */
public class Boj1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 1. 배열 값 내림차순 정렬
        PriorityQueue<Integer> queue = new PriorityQueue<>((x,y) -> Integer.compare(y,x));

        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        List<Integer> calculated = new ArrayList<>();

        while(!queue.isEmpty()) {
            // 현재 값
            int current = queue.poll();

            // 다음 값 없을 경우 현재 값만 넣고 while 문 종료
            if(queue.peek() == null) {
                calculated.add(current);
                break;
            }

            // 1. 현재 양수 일 때
            if (current > 0) {
                if(queue.peek() > 0) {
                    calculated.add(current * queue.poll());
                }else {
                    calculated.add(current);
                }
            }
            // 2. 현재 0일 때
            else if (current == 0) {
                if(queue.size() / 2 == 0) {
                    calculated.add(current);
                }else {
                    calculated.add(current * queue.poll());
                }
            }
            // 3. 현재 음수 일때
            else {
                calculated.add(current * queue.poll());
            }
        }

        // 4. 최댓값 구하기
        int maxSum = calculated.stream().mapToInt(Integer::intValue).sum();
        System.out.println(maxSum);
    }
}
