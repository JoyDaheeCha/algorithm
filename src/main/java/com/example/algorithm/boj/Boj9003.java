package com.example.algorithm.boj;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 단어 뒤집기
* */
public class Boj9003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {

           String sentence = br.readLine();

           // 1. 스택에 영단어 넣기
            for (int j = 0; j < sentence.length(); j++) {
                stack.push(sentence.charAt(j));
            }

            // 2. 문장 뒤집기
            while (!stack.isEmpty()) {
               sb.append(stack.pop());
            }

            // 3. 뒤집어진 문장 자르기
            String[] reversedWords = sb.toString().split(" ");

            sb.setLength(0);

            // 4. 문장 순서 바꾸기
            for (int j = reversedWords.length - 1; j >= 0; j--) {
                sb.append(reversedWords[j]).append(" ");
            }

            // 5. 출력 버퍼에 저장 =
            bw.write(sb + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
