package com.example.algorithm.goorm;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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
        
        int start = 0;
        int destination = n * n; // 예: n= 5 -> 25
        
        // 2. 각 좌표별로 고유 값 지정 (예. if n = 5, then [0.0] -> 1, [n-1][n-1] = 25)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = (i+1)*(j+1) * graph[i][j];
            }
        }
        
        
        // 3. 연결 관계 정리
        ArrayList<Integer>[] con = new ArrayList[destination + 1]; // 1~ destination 사용 예정 

        for (int i = 1; i < destination + 1; i++) {
            con[i] = new ArrayList<>(); // 초기화 꼭 해야함. 없으면 NPE 생김
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int pos = graph[i][j]; // 현재 위치 고유 값
                
                if(pos != 0) {
                    if (i - 1 >= 0 && graph[i - 1][j] > 0) { // 위 
                        con[pos].add(graph[i - 1][j]);
                    }
                    if (i + 1 <= n -1 && graph[i + 1][j] > 0) { // 아래
                        con[pos].add(graph[i + 1][j]);
                    }
                    if (j - 1 >= 0 && graph[i][j - 1] > 0) { // 왼쪽
                        con[pos].add(graph[i][j - 1]);
                    }
                    if (j + 1 <= n -1 && graph[i][j + 1] > 0) { // 오른쪽
                        con[pos].add(graph[i][j + 1]);
                    }
                }
            }
        }

        // 4. 오름차순으로 각 노드별 연결 관계 정렬
        for (int i = 1; i < con.length; i++) {
            Collections.sort(con[i]); // 0은 NPE 발생하므로 미포함
        }

        Queue<Integer> queue = new LinkedList<>();
        
        int[] distance = new int[destination+1]; //출발지점에서 각 node 별 거리 
        
        queue.offer(1);
        
        if(!queue.isEmpty()) {
            int x = queue.poll();
            
            if (distance[x] == 0) {
                for (Integer integer : con[x]) {
                    
                }
            }
        }
        
        
    }
}
