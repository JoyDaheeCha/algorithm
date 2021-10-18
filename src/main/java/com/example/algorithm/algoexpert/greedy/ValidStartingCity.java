package com.example.algorithm.algoexpert.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * algoExpert / Greedy / medium
 *
 * 내가 풀었을 때 복잡도 : O(n^2)
* */
public class ValidStartingCity {
    public static void main(String[] args) {
        int result = validStartingCity(new int[]{5, 25, 15, 10, 15}, new int[]{1,2,1,0,3}, 10);
        System.out.println(result);
    }

    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {

        List<Integer> cities = IntStream.of(distances).boxed().collect(Collectors.toList());

        int validCityIdx = 0;
        for (int i = 0; i < cities.size(); i++) {
            validCityIdx = i;
            boolean isValid = true;
            double remaining = 0; // 현재 사용 가능한 가스양
            for (int j = 0; j < cities.size(); j++) {
                remaining += fuel[j]; // 가스 충전
                remaining -= (double) distances[j] / mpg;
                if(remaining < 0) {
                    isValid = false;
                    break;
                }
            }
            //valid 할 경우 탐색 종료.
            if(isValid) {
                break;
            }
            // valid하지 않을 경우 다음 city로 넘어가자.
            int notValid = cities.remove(0);
            cities.add(notValid);
        }
        return validCityIdx;
    }
}
