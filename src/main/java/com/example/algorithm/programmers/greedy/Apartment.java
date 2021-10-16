package com.example.algorithm.programmers.greedy;

import java.util.LinkedList;
import java.util.List;

/**
 * 프로그래머스 / 그리디 / 기지국
 * N: 200,000,000 이므로 배열 선언하지 말것.
 *
 * 블로그 설명: https://tosuccess.tistory.com/88
* */
public class Apartment {
    public static void main(String[] args) {
        //System.out.println((solution(20, new int[]{4,11}, 2))); // 기댓값 4
        System.out.println((solution(16, new int[]{9}, 2))); // 기댓값 3
        //System.out.println((solution(11, new int[]{4,11}, 1))); // 기댓값 3
    }

    public static int solution(int n, int[] stations, int w) {
        // 1. 한 기지국의 영향 범위 구하기
        int eLen = 1 + 2*w; // W는 자연수

        int left = 0;
        int right = 0;

        int baseL = 0;
        int baseR = 0;

        int count = 0; // 추가로 설치할 기지국 수
        for (int i = 0; i < stations.length; i++) {
            int cur = stations[i];

            left = baseR + 1;

            baseL = cur - w;
            baseR = cur + w;

            if(baseL < 0) baseL = 0;
            if(baseR > n) baseR = n;

            right = baseL - 1;

            if(right < 0) continue;
            if(right < left) continue;

            double gap = (double) (right - left + 1) / eLen;
            if(gap % 1 == 0) count += (int) gap;
            else count += (int) gap + 1;
        }

        // 모두 다 커버되지 않았을 경우
        if(baseR != n) {
            double gap = (double) (n - (baseR+1) + 1) / eLen;
            if(gap % 1 == 0) count += (int) gap;
            else count += (int) gap + 1;
        }

        return count;
    }
}
