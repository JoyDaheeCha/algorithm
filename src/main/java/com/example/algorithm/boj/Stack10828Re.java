package com.example.algorithm.boj;

import java.io.*;
import java.util.Stack;

public class Stack10828Re {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 명령어 갯수
        int n = Integer.parseInt(br.readLine());

        // 스택 생성
        Stack<String> stack = new Stack();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if(command.contains("push")) { // e.g. push 1
                String[] spt = command.split(" ");
                stack.push(spt[1]);
            }else if(command.contains("pop")) {
                if(stack.isEmpty()) {
                    bw.write("-1" + "\n");
                }else {
                    bw.write(stack.pop() + "\n");
                }
            }else if(command.contains("size")) {
                bw.write(stack.size() + "\n");
            }else if(command.contains("empty")) {
                if(stack.isEmpty()) {
                    bw.write("1" + "\n");
                }else {
                    bw.write("0" + "\n");
                }
            }else if(command.contains("top")) {
                if(stack.isEmpty()) {
                    bw.write("-1" + "\n");
                }else {
                    bw.write(stack.peek() + "\n");
                }
            }else {
                throw new IllegalStateException("Your command is not acceptable");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
