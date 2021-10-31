package com.example.algorithm.programmers.greedy.lv2;

/**
* 조이스틱 설명 url : https://parksuu.github.io/139-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A1%B0%EC%9D%B4%EC%8A%A4%ED%8B%B1-(java)/
* 왜 min = Math.min(min, given.length-nextIdx+i*2)인지 이해하는데 오래 걸렸음.
* * */
public class Joystick1 {
    public static void main(String[] args) {
        System.out.println(solution("JAN")); //23 ZAAAZZZZZZZ
        System.out.println(solution("ZAAAZZZZZZZ")); //15
    }

    public static int solution(String name) {
        int answer = 0;

        char[] given = name.toCharArray();
        int min = given.length - 1;

        for(int i = 0; i < given.length; i++) {
            // 1. 알파벳 바꾸는 횟수
            int diff = Math.min('Z' - given[i] + 1, given[i] - 'A'); // 거꾸로 or 정방향
            answer += diff;

            int nextIdx = i+1; // 오른쪽 한 칸 이동

            while(nextIdx < given.length && given[nextIdx] == 'A') {
                nextIdx++;
            }

            min = Math.min(min, given.length-nextIdx+i*2);
        }

        answer += min;

        return answer;
    }
}