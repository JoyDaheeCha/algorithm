package com.example.algorithm.programmers.greedy.lv2;

import java.util.*;

/**
 * 프로그래머스 / 그리디 lv2. 큰 수 만들기
 * 시간 복잡도 O(n)
 *
 * 참고한 로직: https://gurumee92.tistory.com/162
* */
public class BigNumber2 {
    public static void main(String[] args) {
        System.out.println(solution("4177252841", 4)); // 775841
    }
    public static String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i < number.length(); i++) {
            char now = number.charAt(i);
            if(stack.isEmpty() || stack.peek() >= now || k == 0) {
                stack.push(now);
            }else {
                while(!stack.isEmpty() && k > 0 && stack.peek() < now) {
                    stack.pop();
                    k--;
                }
                stack.push(now);
            }
        }

        // 1111, 10000인 경우
        while(k!=0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
