package com.example.algorithm.boj;

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Boj9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int commandN = Integer.parseInt(br.readLine());

        for (int i = 0; i < commandN; i++) {
            bw.write(solution(br.readLine())+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static String solution(String command) throws IOException {
        Deque<String> deque = new LinkedList<>();

        String[] spt = command.split("");
        for (String s : spt) {
            if(s.equals("(")) {
                deque.push(s);
            }else if(s.equals(")")) {
                if(deque.isEmpty()) {
                    return "NO";
                }
                deque.pop(); // ( 제거
            }
        }
        if (!deque.isEmpty()) {
            return "NO";
        }

        return "YES"; // 정상인 경우

    }
}
