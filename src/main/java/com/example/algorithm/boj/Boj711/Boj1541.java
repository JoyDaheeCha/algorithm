package com.example.algorithm.boj.Boj711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* 백준 1541 / 잃어버린 괄호 / 그리디
 *
 * 솔루션: 가장 큰 수를 뺄 수 있도록 최대한 더한다.
 * 설명된 블로그 : https://st-lab.tistory.com/148
* */
public class Boj1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer subGroup = new StringTokenizer(br.readLine(), "-"); // - 기준으로 자르기

        int result = 0; // 식 전체 계산 결과

        int calIdx = 0; // 전체 식에서 계산 수행한 횟수

        while(subGroup.hasMoreTokens()) {
            String nums = subGroup.nextToken();
            StringTokenizer addGroup = new StringTokenizer(nums, "+"); // + 기준으로 자르기

            int added = 0;
            while(addGroup.hasMoreTokens()) {
                added += Integer.parseInt(addGroup.nextToken());
            }

            if(calIdx == 0) {
                result += added;
            }else {
               result -= added;
            }
            calIdx++;

        }

        System.out.println(result);
    }
}
