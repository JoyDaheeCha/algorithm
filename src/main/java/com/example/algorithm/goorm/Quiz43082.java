package com.example.algorithm.goorm;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 구름 EDU / 최단거리 구하기
 *
 * - 주의: 방문처리 하기!! (visit[i][j] = true)
* */
public class Quiz43082 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 10
        
        // 1. 그래프 만들기
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 도착지점 or 시작지점이 0이면 리턴
        if(graph[0][0] == 0 || graph[n-1][n-1] == 0) {
            return;
        }

        boolean[][] visit = new boolean[n][n]; // 방문함: true / 미방문: false

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0,0});

        while(!queue.isEmpty()) {
            int[] pos = queue.poll(); // 현재 포지션
            int i = pos[0];
            int j = pos[1];

            // 현재 destination이면 return
            if(i == n-1 && j == n-1) {
                System.out.println(graph[i][j]);
                return;
            }

            if(!visit[i][j]) {
                if (i - 1 >= 0 && graph[i - 1][j] > 0) { // 위
                    queue.offer(new int[]{i - 1, j});
                    graph[i - 1][j] = graph[i][j] + 1;
                }
                if (i + 1 <= n -1 && graph[i + 1][j] > 0) { // 아래
                    queue.offer(new int[]{i + 1, j});
                    graph[i + 1][j] = graph[i][j] + 1;
                }
                if (j - 1 >= 0 && graph[i][j - 1] > 0) { // 왼쪽
                    queue.offer(new int[]{i, j - 1});
                    graph[i][j - 1] = graph[i][j] + 1;
                }
                if (j + 1 <= n -1 && graph[i][j + 1] > 0) { // 오른쪽
                    queue.offer(new int[]{i, j + 1});
                    graph[i][j + 1] = graph[i][j] + 1;
                }
                visit[i][j] = true;
            }
        }

        return;

    }
}
