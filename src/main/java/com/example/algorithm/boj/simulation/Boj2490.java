package com.example.algorithm.boj.simulation;

import java.io.*;
import java.util.Arrays;

public class Boj2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {
            String positions = br.readLine();
            int zeroCount = count(positions, "0"); // 배
            int oneCount = count(positions, "1"); // 등

            bw.write(score(zeroCount, oneCount)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int count(String positions, String target) {
        return (int) Arrays.stream(positions.split(" ")).filter(target::equals).count();
    }

    private static String score (int zeroCount, int oneCount) {
        if(zeroCount == 1 && oneCount == 3) {
           return "A";
        }

        if(zeroCount == 2 && oneCount == 2) {
            return "B";
        }

        if(zeroCount == 3 && oneCount == 1) {
            return "C";
        }

        if(zeroCount == 4 && oneCount == 0) {
            return "D";
        }

        if(zeroCount == 0 && oneCount == 4) {
            return "E";
        }

        throw new IllegalStateException("A,B,C,D,E 외에는 존재할 수 없습니다.");
    }
}
