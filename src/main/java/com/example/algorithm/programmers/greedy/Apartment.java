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
        System.out.println((solution(20, new int[]{4,11}, 2))); // 기댓값 4
        System.out.println((solution(16, new int[]{9}, 2))); // 기댓값 3
        System.out.println((solution(11, new int[]{4,11}, 1))); // 기댓값 3
    }

    public static int solution(int n, int[] stations, int w) {
        int count = 0; // 기지국 총 갯수

        int baseL = 0; // 기지국 전파 범위 시작
        int baseR = 0; // 기지국 전파 범위 끝

        int left = 0; // 전파 미도달 시작
        int right = 0; // 전파 미도달 끝
        int bandWidth = 2*w + 1;

        for (int i = 0; i < stations.length; i++) {

            // 0. 기지국 이전에 위치한 아파트중 전파 미도달 범위 구하기
            left = baseR + 1;

            int base = stations[i];
            baseL = base - w;
            baseR = base + w;

            if(baseL < 1) baseL = 1;
            if(baseR > n) baseR = n;

            right = baseL - 1;

            // 1. 예외: 두 기지국 사이에 전파 미도달 범위가 없을 경우 or 1번째 기지국이 앞의 아파트 모두 커버했을 경우
            if(right < left) continue;

            int gap = right - left + 1;

            if(gap % bandWidth == 0) {
                count += gap / bandWidth;
            }else {
                count += gap / bandWidth + 1;
            }
        }

        if (baseR != n) {
            int gap = n - baseR;

            if(gap % bandWidth == 0) {
                count += gap / bandWidth;
            }else {
                count += gap / bandWidth + 1;
            }
        }

        return count;
    }
}
