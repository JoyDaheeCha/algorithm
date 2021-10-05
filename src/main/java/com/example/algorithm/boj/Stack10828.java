package com.example.algorithm.boj;

import java.io.*;
import java.util.Stack;

public class Stack10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 명령어 갯수
        int n = Integer.parseInt(br.readLine());

        // 스택 생성
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String commands = br.readLine();

            if(commands.contains("push")) {
                String spt[] = commands.split(" ");
                stack.push(Integer.parseInt(spt[1]));
            }else if(commands.contains("pop")) {
                if(stack.empty()) {
                    bw.write(-1 +"\n");
                }else {
                    bw.write(stack.pop() + "\n");
                }
            }else if(commands.contains("size")) {
                bw.write(stack.size() +"\n");
            }else if(commands.contains("empty")) {
                if(stack.empty()) {
                    bw.write(1 +"\n");
                }else {
                    bw.write(0 +"\n");
                }
            }else if(commands.contains("top")) {
                if(stack.empty()) {
                    bw.write(-1 +"\n");
                }else {
                    bw.write(stack.peek() +"\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
