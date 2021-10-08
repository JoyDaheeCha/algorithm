package com.example.algorithm.boj.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1202 / 보석 도둑
* */
public class Boj1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 0. 입려 받기
        int n = Integer.parseInt(st.nextToken()); // 보석 수
        int k = Integer.parseInt(st.nextToken()); // 가방 수

        int[][] jew = new int[n][2];
        int[] bag = new int[k];

        // 1.1 보석 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jew[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        // 1.2 가방 초기화
        for (int j = 0; j < k; j++) {
            bag[j] = Integer.parseInt(br.readLine());
        }

        // 2.1 보석 정렬
        Arrays.sort(jew, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]); // 무게 같을 경우 가격 내림 차순
            }
            return Integer.compare(o1[0], o2[0]); // 무게 오름 차순
        });

        // 2.2 가방 정렬
        Arrays.sort(bag);

        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2, o1))); // 가격 내림 차순 정렬

        long priceSum = 0;

        int jewIdx = 0;
        for (int i = 0; i < k; i++) {
            while(jewIdx < n && jew[jewIdx][0] <= bag[i]) {
                queue.add(jew[jewIdx][1]);
                jewIdx++;
            }
            if(!queue.isEmpty()) {
                priceSum += queue.poll();
            }
        }

        System.out.println(priceSum);
    }
}
