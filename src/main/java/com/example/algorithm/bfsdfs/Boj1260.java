package com.example.algorithm.bfsdfs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 백준 / BFS, DFS 개념 잡기 / 1260
 *
 * 설명 : https://developer-mac.tistory.com/63
 *
 * 기억할 것: DFS는 stack 또는 재귀, BFS는 Queue를 사용한다.
 *
 * 실수하지 말것 :
 * - queue isEmpty 는 if가 아니라 while 써야 함!!!
 * - u -> v 방문시 작은 수부터 방문해야함! (정렬하기)
 * - graph의 0번 노드는 null이므로 sort 적용하지 말것
 * - 인덱스명 헷갈리지 않게 적기 (bfs for문 안에서 u 대신 s 적어서 삽질함..)
* */
public class Boj1260 {
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    private static List<Integer> dfsHistory;
    private static List<Integer> bfsHistory;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 정점의 개수 1 <= n <= 1000 , 정점 번호: 1 이상
        int m = sc.nextInt(); // 간선의 개수 1 <= m <= 10000
        int s = sc.nextInt(); // 탐색 시작

        // 1. 그래프 초기화
        graph = new ArrayList[n+1];

        for (int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        // 2. 입력 받기
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(); // 현 정점
            int v = sc.nextInt(); // 연결된 정점

            graph[u].add(v); // 현 정점 -> 연결 정점
            graph[v].add(u); // 연결 정점 -> 현 정점
        }

        // 3. u -> v 연결시 작은 수부터 방문하도록 정렬
        for (int i = 1; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        // 4.1 dfs
        visited = new boolean[n+1]; // 방문 기록. false: 미방문, true: 방문
        dfsHistory = new LinkedList<>();
        dfs(s);
        System.out.println(dfsHistory.stream()
                                    .map(String::valueOf)
                                    .collect(Collectors.joining(" ")));

        // 4.2 bfs
        visited = new boolean[n+1]; // 방문 기록 초기화
        bfsHistory = new LinkedList<>();
        bfs(s);
        System.out.println(bfsHistory.stream()
                                        .map(String::valueOf)
                                        .collect(Collectors.joining(" ")));
    }

    private static void dfs(int s) {

        // 이미 방문했을 경우 하위에 대해 탐색 x
        if(visited[s]) {
            return;
        }

        // 방문 처리
        visited[s] = true;
        dfsHistory.add(s);

        for (int v : graph[s]) {
            dfs(v);
        }
    }

    private static void bfs(int s) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        // 이미 방문했을 경우 하위에 대해 탐색 x
        while(!queue.isEmpty()) {
            int u = queue.poll();
            if (!visited[u]) {
                // 방문 처리
                visited[u] = true;
                bfsHistory.add(u);

                for (int v : graph[u]) {
                    queue.offer(v);
                }
            }
        }
    }
}
