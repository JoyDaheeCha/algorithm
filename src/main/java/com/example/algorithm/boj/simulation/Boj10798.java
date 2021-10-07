package com.example.algorithm.boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class Boj10798 {

    public static void main(String[] args) throws IOException {
        int sentneceCount = 5;
        int wordLen = 26;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] words = new String[wordLen][sentneceCount];

        for (int i = 0; i < sentneceCount; i++) {
            Arrays.fill(words[i], "");
        }

        for (int i = 0; i < sentneceCount; i++) {
            words[i] = br.readLine().split("");
        }

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < wordLen; j++) {
            for (int k = 0; k < sentneceCount; k++) {
                sb.append(words[j][k]);
            }
        }

        System.out.println(sb);
    }
}
