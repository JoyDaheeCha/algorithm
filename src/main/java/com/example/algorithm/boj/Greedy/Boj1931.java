package com.example.algorithm.boj.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 / Greedy / 1931 : 회의실 배정
 *
 * 해결법: 끝나는 시간이 가장 빠른 회의실 부터 회의실 배정
* */
public class Boj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 회의 수 저장
        int n = Integer.parseInt(br.readLine()); // 회의의 수
        int[][] schedules = new int[n][2];

        // 2. 각 회의별 시작/종료 시간 대입
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            schedules[i][0] = Integer.parseInt(input[0]);
            schedules[i][1] = Integer.parseInt(input[1]);
        }

        // 3. 더 빨리 끝나는 회의를 우선 배치. 끝나는 시간이 같을 경우 더 빨리 시작하는 회의를 우선 배치
        Arrays.sort(schedules, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]); // 더 빨리 시작하는 회의가 우선 순위가 높다.
            }
            return Integer.compare(o1[1], o2[1]); // 더 빨리 끝나는 회의가 우선 순위가 높다
        });

        // 4. 회의실 이영 가능한 미팅 최대 개수 계산
        int meetingMaxCount = 0;
        int[] lastMeeting = {0,0}; // 회의실 이용 가능한 미팅 중 가장 마지막 아이템

        for (int[] schedule : schedules) {
            if (lastMeeting[1] <= schedule[0]) {
                lastMeeting = schedule;
                meetingMaxCount++;
            }
        }

        System.out.println(meetingMaxCount);
        br.close();
    }
}
