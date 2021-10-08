package com.example.algorithm.boj.Greedy;

import java.io.IOException;
import java.util.*;

/**
 * 백준 12015 가장 긴 증가하는 부분 수열 2
 *
 * 요구사항:
 * 배열의 입력 순서를 유지
 * 오름차순
 * 가장 긴 수열 찾기
 *
 * 설명: https://dragon-h.tistory.com/2
* */
public class Boj12015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<Integer> longest = new ArrayList<>();
        longest.add(0);

        for (int i = 0; i < n; i++) {
            int curNum = nums[i];
            int lastL = longest.get(longest.size()-1); // longest의 마지막 요소
            if( lastL < curNum){
                longest.add(curNum);
            }else if(lastL == curNum) {
                // do nothing
            }else {
                int left = 0;
                int right = longest.size() - 1;
                int mid = (left + right) / 2;

                if (left < right) {
                    if (longest.get(mid) >= curNum) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                longest.set(right, curNum);
            }
        }

        System.out.println(longest.size()-1);
    }
}
