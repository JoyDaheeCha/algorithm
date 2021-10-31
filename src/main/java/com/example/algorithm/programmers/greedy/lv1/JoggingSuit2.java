package com.example.algorithm.programmers.greedy.lv1;

import java.util.*;

/**
 * 내가 풀었음.
 * time complexity : O(n^2)
 * 학생 수 30명이라 가능했지만, 만약 수가 커진다면 다른 방법을 시도해야함.
* */
class JoggingSuit2 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 도난 당했을 경우
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                }
            }
        }

        // 빌리기
        for(int i = 0; i < lost.length; i++) {
            if(lost[i] == -1) {
                continue;
            }
            int prev = lost[i] - 1;
            int next = lost[i] + 1;

            for(int j = 0; j < reserve.length; j++) {
                if(reserve[j] == prev || reserve[j] == next) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
            if(lost[i] != -1) {
                answer--;
            }
        }

        return answer;
    }
}