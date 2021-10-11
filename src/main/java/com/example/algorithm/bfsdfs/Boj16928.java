package com.example.algorithm.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16928 {
    private static HashMap<Integer, Integer> ladder = new HashMap<>(); // n < ladder.get(n)
    private static HashMap<Integer, Integer> snake = new HashMap<>(); // m > snake.get(m)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken()); // 사다리 수 1~15
        int k = Integer.parseInt(st.nextToken()); // 뱀 수 1~15

        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            ladder.put(from, to);
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            snake.put(from, to);
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int cnt = 0;
        boolean[] visited = new boolean[101]; // 위치값: 1~100
        Queue<Integer> q = new LinkedList<>();

        visited[1] = true;
        q.offer(1);

        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {

                int cur = q.poll();

                if(cur == 100) return cnt;

                for (int dice = 1; dice <= 6; dice++) {
                    int next = cur + dice;

                    if(next > 100 ) {
                        break;
                    }

                    if(ladder.containsKey(next)) {
                        next = ladder.get(next);
                    }else if(snake.containsKey(next)) {
                        next = snake.get(next);
                    }

                    if(visited[next]) {
                        continue;
                    }

                    q.offer(next);
                    visited[next] = true;
                }
            }
            cnt++;
        }
        return cnt;
    }
}
