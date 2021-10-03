package com.example.algorithm.programmers.stackqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 > 스택,큐 > 기능 개발
* */
public class Development {
    public int[] solution(int[] progresses, int[] speeds) {
        // 1. 정답
        ArrayList<Integer> answer = new ArrayList<>();

        // 2. 개발 일수
        int[] days = new int[progresses.length];

        // 3. 큐 자료 구조
        Queue<Integer> queue = new LinkedList<>();

        // 4. 각 기능 개발 일수 계산
        for (int i = 0; i < days.length; i++) {
            days[i] = (100-progresses[i]) % speeds[i] == 0 ? (100-progresses[i]) % speeds[i] : (100-progresses[i]) % speeds[i] + 1;
            queue.offer(days[i]);
        }

        while(!queue.isEmpty()) {
            int cnt = 1;
            int num = queue.poll();
            while(queue.peek() != null & queue.peek() <= num) {
                int temp = queue.poll();
                cnt++;
                num = Math.max(temp, num);
            }
            answer.add(cnt);
        }
        return answer.toArray(new Integer[answer.size()])
    }
}
