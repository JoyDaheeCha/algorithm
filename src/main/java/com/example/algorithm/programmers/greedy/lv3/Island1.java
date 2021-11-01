package com.example.algorithm.programmers.greedy.lv3;

/**
 * 섬 연결하기
 *
 * 내가 시도한 방법: 최소 비용을 가진 섬부터 연결
 *
 * 결과: 실패
 *
 * 성공한 테스트 케이스 : 4	[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]	4
 * 내가 발견한 반례: 섬 개수 3, 간선 [[0,1,1], [2,3,2], [1,2,3]], 예상 값 6 -> IndexOutOfBound 오류 남.
 */

import java.util.*;

public class Island1 {
    public int solution(int n, int[][] costs) {

        // 방문 여부
        boolean[] visited = new boolean[n];

        // 방문한적 없는 섬의 개수
        int notVisitdCnt = n;

        // 최소 비용
        int minCost = 0;

        // cost 오름 차순 정렬
        Arrays.sort(costs, (o1,o2) -> {
            if(o1[2] == o2[2]) {
                return Integer.compare(o1[0], o2[0]);
            }else if(o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[2], o2[2]);

        });

        int idx = 0;
        while(notVisitdCnt > 0) {
            int beg = costs[idx][0];
            int end = costs[idx][1];
            int money = costs[idx][2];

            if(!visited[beg] && !visited[end]) {
                visited[beg] = true;
                visited[end] = true;
                notVisitdCnt -= 2;
                minCost += money;

            }else if(!visited[beg]) {
                visited[beg] = true;
                notVisitdCnt--;
                minCost += money;

            }else if(!visited[end]) {
                visited[end] = true;
                notVisitdCnt--;
                minCost += money;

            }else {
                // do nothing (두 섬 모두 이미 방문됐을 경우)
            }
            idx++;
        }

        return minCost;
    }

}
