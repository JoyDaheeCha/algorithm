package com.example.algorithm.programmers.bruteforce;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 프로그래머스 > 완전탐색 > 모의고사
* */
public class PrimeNumber {
    public int solution(String numbers) {

        List<String> nums = Arrays.asList(numbers.split(""));

        ArrayList<Integer> combined = new ArrayList<>();


        int answer = 0;
        return answer;
    }

    public boolean isPrime(int num) {
        int sqrtNum = (int)Math.sqrt(num); // 제곱근
        boolean flag = true;

        if(num == 2) {
            flag = true;
        }
        else if(num%2==0||num==1) {
            flag = false;
        }
        else{
            for(int i=3;i<sqrtNum;i+=2) {
                if(num%i==0){
                    flag = false;

                }
            }
        }
        return flag;
    }
}
