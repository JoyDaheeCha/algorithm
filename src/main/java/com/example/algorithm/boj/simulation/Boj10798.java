package com.example.algorithm.boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10798 {

    public static void main(String[] args) throws IOException {
        int sentneceCount = 5;
        int wordLen = 26;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] words = new String[sentneceCount][wordLen];

        for (int i = 0; i < sentneceCount; i++) {
            String[] word = br.readLine().split("");
            System.arraycopy(word, 0, words[i], 0, word.length);
        }

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < wordLen; j++) {
            for (int k = 0; k < sentneceCount; k++) {
                String current = words[k][j];
                if(current != null) {
                    sb.append(words[k][j]);
                }
            }
        }

        System.out.println(sb);
    }
}
