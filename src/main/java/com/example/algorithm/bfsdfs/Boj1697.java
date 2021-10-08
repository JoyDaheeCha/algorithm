package com.example.algorithm.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1697 {

    private static int[] visit; // 0: 방문한 적 없음. n(n>0): 방문 횟수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        visit = new int[100001];

        // 수빈이와 동생이 같은 위치에 있을 경우
        if (n == k) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs(n, k));
    }

    // a: 수빈이 위치, k; 동생의 위치
    private static int bfs(int a, int k ) {
        Queue<Integer> queue = new LinkedList<>();
        visit[a] = 0; // 처음위치에서의 이동 횟수는 0
        queue.offer(a);

        while(!queue.isEmpty()) {
            int c = queue.poll(); // 수빈이의 현재 위치
            if (visit[k] != 0) {
                break; // 동생의 위치에서 이동 횟수 기록이 발견될 경우, 수빈이와 동생이 만났다는 것을 뜻하므로 이동횟수 return
            }

            if (c-1 >= 0 && visit[c-1] == 0) {
                visit[c-1] = visit[c] + 1;
                queue.offer(c-1);
            }

            if(c+1 <= visit.length-1 && visit[c+1] == 0) {
                visit[c+1] = visit[c] + 1;
                queue.offer(c+1);
            }

            if(c*2 <= visit.length-1 && visit[c*2] == 0) {
                visit[c*2] = visit[c] + 1;
                queue.offer(c*2);
            }
        }
        return visit[k];
    }
}
