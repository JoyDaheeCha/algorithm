package com.example.algorithm.programmers.greedy.lv3;

import java.util.Arrays;

/**
 * 투포인트. 가장 가벼운 사람 & 가장 무거운 사람 함께 담기 시도. 안되면 무거운 사람 혼자 보낸다.
 *
 * 시간 복잡도 O(n)
 *
 * 블로그 설명: https://velog.io/@ajufresh/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B5%AC%EB%AA%85%EB%B3%B4%ED%8A%B8-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-Java
 */
public class Boat1 {
    public int solution(int[] people, int limit) {

        // 무게 오름 차순 정렬
        Arrays.sort(people);

        int boatCnt = 0; // 보트 총 수
        int beg = 0; // 첫 사람 idx
        int end = people.length-1; // 마지막 사람 idx

        while(beg <= end) {
            if(people[beg] + people[end] <= limit) {
                beg++;
                end--;
            }else {
                end--;
            }
            boatCnt++;
        }
        return boatCnt;
    }
}
