package com.example.algorithm.algoexpert.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * algoExpert / greedy / medium
* */
public class TaskAssignment {
    public static void main(String[] args) {
        System.out.println(taskAssignment(3, new ArrayList<>(Arrays.asList(1, 3, 5, 3, 1, 4))));
    }

    public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {

        ArrayList<ArrayList<Integer>> idxes = new ArrayList<>();

        for (int i = 0; i < 2*k; i++) {
            idxes.add( new ArrayList<>(Arrays.asList(i, tasks.get(i)))); // idx, task duration 순
        }
        idxes.sort(Comparator.comparingInt(o1 -> o1.get(1))); // duration 오름 차순 정렬

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        // 인덱스 넣기
        for (int i = 0; i < k; i++) {
            answer.add(new ArrayList<>(Arrays.asList(idxes.get(i).get(0), idxes.get(2 * k - i - 1).get(0))));
        }

        return answer;
    }
}
