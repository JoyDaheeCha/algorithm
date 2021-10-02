package com.example.algorithm.programmers.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 프로그래머스 > 정렬 > 가장 큰 수
 *
 * 기억할 것 : reverseOrder
* */
public class BiggestNum {
    public String solution(int[] numbers) {

        // 1. 내림 차순 sorting
        List<String> parsed = Arrays.stream(numbers)
                                    .mapToObj(Integer::toString)
                                    .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                                    .collect(Collectors.toList());

        // 2. 가장 큰 수가 0인 경우: 나머지도 0일것이므로, 0리턴
        if (parsed.get(0).equals("0")) {
            return "0";
        }

        return String.join("", parsed);
    }
}
