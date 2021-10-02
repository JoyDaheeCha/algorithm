package com.example.algorithm.programmers;

import java.util.Arrays;

public class Greedy1 {

    public int solution(int n, int[] losts, int[] reserves) {
        int answer = n - losts.length;

        Arrays.sort(losts);
        Arrays.sort(reserves);

        // 1. 여벌 체육복 가진 학생이 도둑 맞았을 경우
        for (int i = 0; i < losts.length; i++) {
            for (int j = 0; j < reserves.length; j++) {
                if(losts[i] == reserves[j]) {
                    losts[i] = -1;
                    reserves[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        // 2. 도둑 맞은 학생이 빌릴 수 있는지 조사
        for (int i = 0; i < losts.length; i++) {
            int cur = losts[i];
            int pre = cur - 1;
            int next = cur + 1;
            for (int j = 0; j < reserves.length; j++) {
                if (reserves[j] == pre || reserves[j] == next) {
                    losts[i] = -1;
                    reserves[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
