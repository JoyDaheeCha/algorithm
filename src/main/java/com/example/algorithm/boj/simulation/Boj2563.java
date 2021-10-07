package com.example.algorithm.boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 2563 / 구현 / 색종이
 * https://www.acmicpc.net/problem/2563
* */
public class Boj2563 {

    private static final int WIDTH = 10; // 색종이 한쪽 변 길이
    private static final int WHOLE_WIDTH = 100; // 도화지 한쪽 변 길이
    private static final int OCCUPIED = 1; // 색종이가 붙여져 있을 경우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int [][] whole = new int[WHOLE_WIDTH][WHOLE_WIDTH];
        
        int count = Integer.parseInt(br.readLine());

        // 1. 도화지에 색종이 그리기
        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            for (int j = x; j < x + WIDTH; j++) { // 색종이 가로 길이
                for (int k = y; k < y + WIDTH; k++) { // 색종이 세로 길이
                    whole[k][j] = OCCUPIED;
                }
            }
        }

        // 2. 색종이 넓이 구하기
        int wholeArea = (int) Arrays.stream(whole)
                                    .flatMapToInt(Arrays::stream)
                                    .filter(o -> o == OCCUPIED)
                                    .count();

        System.out.println(wholeArea);
    }
}
