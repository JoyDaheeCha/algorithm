package com.example.algorithm.boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 백준 / 2529 / 부등호
 *
 * 설명 : https://1-7171771.tistory.com/55
* */
public class Boj2529 {
    private static int n;
    private static boolean[] check = new boolean[10]; // 0~9까지 체크
    private static char[] a; // 부등호
    private static ArrayList<String> ans = new ArrayList<>(); // 부등호

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 2 <= n <= 9

        a = String.join("", br.readLine().split(" ")).toCharArray();

        go(0, "");

        Collections.sort(ans);

        System.out.println(ans.get(ans.size()-1));;
        System.out.println(ans.get(0));;

    }

    static void go(int index, String num) {
        if (index == n + 1) {
            ans.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if(check[i]){
                continue;
            }
            if(index == 0 || ck(num.charAt(index-1), (char) (i+'0'), a[index-1])) { // '0'은  48로 간주된다
                check[i] = true;
                go(index+1, num + i);
                check[i] = false;
            }
        }
    }

    static boolean ck(char a, char b, char c) {
        if (c == '<' && a > b) {
            return false;
        }
        if (c == '>' && a < b) {
            return false;
        }
        return true;
    }
}
