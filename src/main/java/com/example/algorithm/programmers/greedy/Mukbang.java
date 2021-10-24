package com.example.algorithm.programmers.greedy;

import com.example.algorithm.nadongbin.Greedy6;

import java.util.*;

/**
 * 무지의 먹방라이브: https://programmers.co.kr/learn/courses/30/lessons/42891
 * 그리디 lv4. 
 * 강의 : https://www.youtube.com/watch?v=4MWxAt4fx5I&t=74s
* */
public class Mukbang {
    class Food {
        int time;
        int idx;

        Food(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }
    }

    Comparator<Food> byTime = new Comparator<Food>() {
        public int compare(Food o1, Food o2) {
            return o1.time - o2.time;
        }
    };

    Comparator<Food> byIdx = new Comparator<Food>() {
        public int compare(Food o1, Food o2) {
            return o1.idx - o2.idx;
        }
    };


    public int solution(int[] food_times, long k) {
        List<Food> foods = new ArrayList<Food>();

        // 1. 시간 순 내림 차순 정렬
        for(int i=0; i<food_times.length; i++) {
            foods.add(new Food(food_times[i], i+1)); // 1번 음식 ~ N번 음식
        }

        foods.sort(byTime);

        long sum = 0; // 지금까지 사용한 총 시간
        int prev = 0; //직전에 다 먹은 음식의 소요시간
        int length = foods.size(); //덜 먹고 남아있는 음식 갯수

        for (int j=0; j<foods.size(); j++) {
            int now = foods.get(j).time;
            long diff = now - prev;
            long spend = diff * length;
            if(sum + spend <= k) {
                sum += spend;
                prev = now;
                length--;
            }else {
                long idx = (k - sum) % length;
                foods.subList(j, foods.size()).sort(byIdx);
                return foods.get(j+(int)idx).idx;
            }
        }

        return -1;
    }
}
