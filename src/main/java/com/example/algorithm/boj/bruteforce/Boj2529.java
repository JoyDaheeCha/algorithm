package com.example.algorithm.boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 백준 / 2529 / 부등호
 *
 * 설명 : https://1-7171771.tistory.com/55
 *
 * 주의 : a + '0' 은 '0'의 Ascii코드를 기준으로 a 만큼 이동하며 a의 ascii 코드를 찾는 방법이다.
 * 이후 (char)(a+'0')을 통해 숫자 a 문자열로 바꾼다.
* */
public class Boj2529 {
    public static char[] a;
    private static int n;
    private static boolean[] use;
    private static ArrayList<String> ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ans = new ArrayList<>();

        n = Integer.parseInt(br.readLine()); // 부등호 갯수
        use = new boolean[10]; // 이미 부응호 사이에 대입된 정수(0~9)일 경우 false;

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 부등호 초기화
        a = new char[n];
        for (int i = 0; i < n; i++) {
            a[i] = st.nextToken().toCharArray()[0];
        }

        go(0, "");

        Collections.sort(ans); // 오름차순 정렬

        System.out.println(ans.get(ans.size()-1));
        System.out.println(ans.get(0));
    }

    private static void go(int index, String numbers) {
        if(index == n+1) {
            ans.add(numbers);
            return;
        }

        for (int i = 0; i <= 9; i++) { // i; 0~9 모두 다를것
            if(use[i]){
                continue;
            }
            if(index == 0 || ck(numbers.charAt(index-1), (char) (i + '0'), a[index-1])) {
                use[i] = true;
                go(index + 1, numbers + i);
                use[i] = false;
            }
        }
    }

    private static boolean ck(char a, char b, char c) {
        if(c == '>' && a < b) {
            return false;
        }
        if(c == '<' && a > b) {
            return false;
        }
        return true;
    }
}
