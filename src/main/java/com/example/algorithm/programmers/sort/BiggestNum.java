package com.example.algorithm.programmers.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 프로그래머스 > 정렬 > 가장 큰 수
 *
 * 기억할 것 : reverseOrder
* */
public class BiggestNum {
    public String solution(int[] numbers) {
        List<String> parsed = Arrays.stream(numbers)
                                    .mapToObj(Integer::toString)
                                    .sorted(Collections.reverseOrder())
                                    .collect(Collectors.toList());

        return String.join("", parsed);
    }
}
