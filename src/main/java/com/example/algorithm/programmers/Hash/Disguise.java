package com.example.algorithm.programmers.Hash;

import java.util.HashMap;

/**
 * 프로그래머스 위장
 * for문 + hashmap
* */
public class Disguise {
    public int solution(String[][] clothes) {
        int answer = 1;

        // 1. 맵에 넣기
        HashMap<String,Integer> cntPerClothes = new HashMap<>();

        for (String[] clothe : clothes) {
            String kind = clothe[1];
            int count = cntPerClothes.getOrDefault(kind, 0);

            cntPerClothes.put(kind, count + 1);
        }

        // 2. 경우의 수 계산
        for (Integer cnt: cntPerClothes.values()) {
            answer = answer*(cnt+1); // 특정 옷 안 입었을 경우 고려하여 +1
        }

        // 3. 아무것도 입지 않았을 경우는 제외
        answer = answer - 1;

        return answer;
    }
}
