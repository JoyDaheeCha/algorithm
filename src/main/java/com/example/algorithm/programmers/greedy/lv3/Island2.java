package com.example.algorithm.programmers.greedy.lv3;

import java.util.*;

/**
 * 프로그래머스 / 그리디 / lv3 / 섬 연결하기
 *
 * 블로그 설명: https://suhyeokeee.tistory.com/178
 */
public class Island2 {
    static int parent[];
    public int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<Node>list = new ArrayList<>();

        parent = new int[101]; // 부모 (0번은 사용하지 않으므로 101개)

        // 자기 자신이 부모
        for(int i=1; i <= 100; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < costs.length; i++) {
            list.add(new Node(costs[i][0], costs[i][1], costs[i][2]));
        }

        // cost 오름 차순 정렬
        Collections.sort(list);

        for(Node a : list) {
            if(isConnectable(a.s, a.e)) {
                answer += a.w;
                union(a.s, a.e);
            }
        }

        return answer;
    }

    public static boolean isConnectable(int x, int y) {
        int p1 = find(x);
        int p2 = find(y);

        if (p1 == p2) {
            return false;
        }
        return true;
    }

    // 작은 수가 부모가 되도록 세팅
    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        parent[Math.max(a,b)] = Math.min(a,b);
    }

    // 최상위 부모를 찾는다.
    public static int find(int x) {
        if (x==parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
class Node implements Comparable<Node> {
    int s,e,w;

    Node(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w; // 내림 차순 정렬
    }
}
