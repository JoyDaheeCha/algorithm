package com.example.algorithm.boj;

import java.io.*;
import java.util.Stack;

/**
 * 백준 10828 스택
 *
 * 기억할 점: Scanenr보다는 BufferedReader가 빠르다.
 * 관련 URL : https://st-lab.tistory.com/175 (스택 설명 자료)
* */


/**
* push X: 정수 X를 스택에 넣는 연산이다.
 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 스택에 들어있는 정수의 개수를 출력한다.
 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *
 * <input>
 * 14
 * push 1
 * push 2
 * top
 * size
 * empty
 * pop
 * pop
 * pop
 * size
 * empty
 * pop
 * push 3
 * empty
 * top
 *
 * <output>
 * 2
 * 2
 * 0
 * 2
 * 1
 * -1
 * 0
 * 1
 * -1
 * 0
 * 3
* */
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
