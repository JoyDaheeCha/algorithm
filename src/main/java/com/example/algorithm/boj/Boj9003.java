package com.example.algorithm.boj;

import java.io.*;

/**
 * 단어 뒤집기
* */
public class Boj9003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String given = new StringBuilder(br.readLine()).reverse().toString();
            String[] spt = given.split(" ");

            StringBuilder sb = new StringBuilder();
            for (int j = spt.length -1 ; j >= 0; j--) {
                sb.append(spt[j]).append(" ");
            }

            bw.write(sb + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
