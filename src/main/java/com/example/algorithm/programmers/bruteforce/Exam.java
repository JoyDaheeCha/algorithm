package com.example.algorithm.programmers.bruteforce;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 프로그래머스 > 완전탐색 > 모의고사
* */
public class Exam {
    public int[] solution(int[] answers) {

        // 1. 학생별 정답 패턴
        HashMap<Integer, int[]> students = new HashMap<>(); // 학생 key, 정답패턴
        students.put(1, new int[]{1, 2, 3, 4, 5});
        students.put(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5});
        students.put(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

        HashMap<Integer, Integer> scores = new HashMap<>();

        for (Map.Entry<Integer, int[]> student : students.entrySet()) {
            Integer key = student.getKey(); // 학생 ID
            int[] stuAns = student.getValue(); // 학생 답안 패턴

            // 2. 학생별 정답
            int score = 0;
            int cur = 0;

            for (int answer : answers) {
                // 정답 패턴 처음으로 돌아갈지 확인
                if(cur == stuAns.length) {
                    cur = 0;
                }

                // 정답 체크
                if (answer == stuAns[cur]) {
                    score++;
                }
                cur++;
            }

            scores.put(key, score);
        }

        //3. 최댓값 확인
        Integer max = Collections.max(scores.values());

        //4. 최댒값 가진 학생 리스트 추출
        List<Integer> studentsWithMax = scores.entrySet().stream()
                         .filter(entry -> entry.getValue() == max)
                         .map(Map.Entry::getKey)
                         .sorted()
                         .collect(Collectors.toList());

        return studentsWithMax.stream().mapToInt(i->i).toArray();
    }
}
