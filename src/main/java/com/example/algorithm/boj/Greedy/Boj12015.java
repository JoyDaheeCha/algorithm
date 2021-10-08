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
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n]; // 입력 받을 수열

        List<Integer> list = new ArrayList<>();
        list.add(0); // 배열의 첫 요소와 비교하기

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int current = nums[i];

            if(current > list.get(list.size()-1)) {
                list.add(current);
            }
            else{
                int left = 0;
                int right = list.size() - 1;
                while(left < right) {
                    int mid = (left + right) / 2;
                    if(list.get(mid) >= current) {
                        right = mid;
                    }else{
                        left = mid + 1;
                    }
                }
                list.set(right, current);
            }
        }
        System.out.println(list.size()-1);
    }
}
