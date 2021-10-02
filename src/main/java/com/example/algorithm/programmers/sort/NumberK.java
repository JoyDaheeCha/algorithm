package com.example.algorithm.programmers.sort;

import java.util.Arrays;

/**
 * 프로그래머스 > 정렬 > k번째 수
* */
public class NumberK {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int from = commands[i][0] - 1;
            int to = commands[i][1];
            int itemIdx = commands[i][2] - 1;

            // 1. 자르기
            int[] subArray = Arrays.copyOfRange(array, from, to);
            Arrays.sort(subArray);

            // 2. k번재 수
            answer[i] = subArray[itemIdx];
        }

        //3. k 배열 출력
        return answer;
    }
}
