package com.example.algorithm.boj.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 / Greedy / 2109 / 순회강연
 *
 * 솔루션 : 가장 비싼 강의를 우선으로, 그리고 최대한 늦게 강연한다.
 *
 * [주의할 테스트 케이스]
 * 3
 * 1  1
 * 10 2
 * 10 2
 * 위 경우에는 2일에 10, 1일에 10 강의가 유리하다
 * (출처: https://www.acmicpc.net/board/view/1885)
* */
public class Boj2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] pd = new int[n][2]; // 가격, 일 순

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pd[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(pd, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return Integer.compare(o2[1],o1[1]);
            }
            return Integer.compare(o2[0], o1[0]);
        }); // 가격 내림 차순, 날짜 내림 차순

        int latestD = Arrays.stream(pd).mapToInt(item -> item[1]).max().orElse(-1);

        boolean[] booked = new boolean[latestD+1]; // d의 범위가 작아서 (0~10,000) 그냥 10001로 둬도 됨.


        long totalIncome = 0;
        for (int i = 0; i < n; i++) {
            for (int j = pd[i][1]; j >= 1; j--) {
                if(!booked[j]) {
                    booked[j] = true; // 강의 스케쥴 잡음
                    totalIncome+= pd[i][0];
                    break;
                }
            }
        }
        System.out.println(totalIncome);
    }
}
