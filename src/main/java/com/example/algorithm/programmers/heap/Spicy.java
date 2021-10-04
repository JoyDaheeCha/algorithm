package com.example.algorithm.programmers.heap;

import java.util.PriorityQueue;

public class Spicy {
    public int solution(int[] scoville, int k) {
        int mixCount = 0;

        // 1. 우선순위 큐에 맵기 내림차순으로 저장
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int sco : scoville) {
            heap.offer(sco);
        }

        while(heap.peek() <= k) {
            //2. 더 섞을 음식이 없을 경우 -1 리턴
            if(heap.size() == 1) {
                return -1;
            }
            int spicyLv1 = heap.poll();
            int spicyLv2 = heap.poll();

            heap.offer(spicyLv1 + spicyLv2 * 2);

            mixCount++;
        }

        return mixCount;
    }
}
