package com.example.algorithm.programmers.greedy;

import java.util.LinkedList;
import java.util.List;

public class Apartment {
    public static void main(String[] args) {
        System.out.println((solution(16, new int[]{9}, 2))); // 기댓값 3
        //System.out.println((solution(11, new int[]{4,11}, 1))); // 기댓값 3
    }
    public static int solution(int n, int[] stations, int w) {
        // 1. 한 기지국의 영향 범위 구하기
        int eLen = 1 + 2*w;

        int[][] effected = new int[stations.length+1][2];
        effected[0] = new int[]{0,0};

        for (int i = 1; i < effected.length; i++) {
            effected[i] = new int[]{stations[i-1]-w, stations[i-1]+w};
        }

        //2. 영향 받지 않는 아파트 그룹 넓이
        List<Integer> noEffectZone = new LinkedList<>();

        for (int i = 1; i < effected.length; i++) {
            noEffectZone.add(effected[i][0]-effected[i-1][1]-1);
        }

        //3. 각 그룹별 기지국 수 구한 후, 전체 기지국 수 구하기
        int totalCnt = 0;
        for (int len : noEffectZone) {
            if(len <= eLen) {
                totalCnt += 1;
            } else {
                totalCnt += len / eLen + 1;
            }
        }

        if(n > effected[effected.length-1][1]) {
            int finalGap = n - effected[effected.length-1][1];
            if(finalGap <= eLen) {
                totalCnt += 1;
            } else {
                totalCnt += finalGap / eLen + 1;
            }
        }

        return totalCnt;
    }
}
