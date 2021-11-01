package com.example.algorithm.programmers.bfsdfs;

import java.util.*;

/**
 * 프로그래머스 network. lv3, bfs (내가 품)
 */
public class Network2 {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for(int i=0; i < computers.length; i++) {
            if(!visited[i]) {
                answer++;
                bfs(i, computers, visited);
            }
        }
        return answer;
    }

    void bfs(int idx, int[][] computers, boolean[] visited) {
        visited[idx] = true;

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(idx);

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int i=0; i < computers[now].length; i++) {
                if(!visited[i] && computers[now][i] == 1) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
