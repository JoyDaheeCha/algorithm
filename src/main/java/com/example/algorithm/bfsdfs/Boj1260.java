package com.example.algorithm.bfsdfs;

import java.util.*;

/**
 * 백준 / BFS, DFS 개념 잡기 / 1260
 *
 * 설명 : https://developer-mac.tistory.com/63
 *
 * 기억할 것: DFS는 stack 또는 재귀, BFS는 Queue를 사용한다.
* */
public class Boj1260 {
    static ArrayList<Integer>[] list;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드 수
        int m = sc.nextInt(); // 간선 수
        int start = sc.nextInt(); // 시작점

        list = new ArrayList[n+1];

        for (int i = 1; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            list[u].add(v); // u 노드에서 v로 연결된다
            list[v].add(u); // v 노드에서 u로 연결된다.
        }

        for (int i = 1; i < n + 1; i++) {
            Collections.sort(list[i]);
        }
        check = new boolean[n+1]; // 1<=N<=1000이 노드의 범위이므로, 인덱스 1에서 시작하기 위해 +1
        dfs(start);
        System.out.println();

        check = new boolean[n+1];
        bfs(start);
        System.out.println();

        sc.close();
    }

    private static void dfs(int x) {
        if (check[x]) {
            return;
        }

        check[x] = true;
        System.out.print(x + " ");
        for (int y: list[x]) {
            if(!check[y]) {
                dfs(y);
            }
        }
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);

        while(!queue.isEmpty()) {
            int u = queue.poll();

            if(!check[u]) {
                for (Integer y : list[u]) {
                    queue.offer(y);
                }
                check[u] = true;
                System.out.print(u + " ");
            }
        }
    }
}
