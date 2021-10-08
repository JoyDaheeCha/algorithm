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

        int n = Integer.parseInt(st.nextToken()); // 보석 수
        int k = Integer.parseInt(st.nextToken()); // 가방 수

        int[][] jew = new int[n][2];
        int[] bag = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jew[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jew, ((o1, o2) -> {
            if(o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]); // 무게가 같을 경우 -> 가격 내림차순
            }
            return Integer.compare(o1[0], o2[0]); // 보석 무게 오름차순 정렬
        }));

        Arrays.sort(bag); // 가방 무게 오름차순 정렬

        PriorityQueue<Integer> queue = new PriorityQueue<>((p1, p2) -> Integer.compare(p2, p1)); // 가격 내림 차순 정렬

        long priceSum = 0; // 보석 총 가격

        int idx = 0; // 보석 idx
        for (int i = 0; i < k; i++) {
            while(idx < n && jew[idx][0] <= bag[i])  {
                queue.add(jew[idx][1]); // 가격 queue에 넣기
                idx++;// 다음 백 보석 결정시, 이번 백에서 고려됐던 보석들은 이미 queue에 담겨있음.
            }
            // 본 백에 담을 보석 결정
            if(!queue.isEmpty()) {
                priceSum += queue.poll();
            }
        }

        System.out.println(priceSum);
    }
}
