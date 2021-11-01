package com.example.algorithm.programmers.greedy.lv3;

import java.util.Arrays;

public class Boat1 {
    public int solution(int[] people, int limit) {

        // 무게 오름 차순 정렬
        Arrays.sort(people);

        int sum = 0; // 현재 보트 내 사람 무게 총 합
        int boatCnt = 1;
        for(int i=0; i < people.length; i++) {
            if(sum + people[i] > limit) {
                sum = people[i]; // 이전에 탄 사람들 무게 제외.
                boatCnt++; // 보트 수 증가
            } else {
                sum += people[i];
            }
        }
        return boatCnt;
    }
}
