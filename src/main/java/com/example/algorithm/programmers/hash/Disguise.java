package com.example.algorithm.programmers.hash;

import java.util.Arrays;
import static java.util.stream.Collectors.*;

/**
 * 프로그래머스 위장
 * solution2. 함수형 프로그래밍
* */
public class Disguise {
    public int solution(String[][] clothes) {
       return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[1], counting())))
                .values()
                .stream().reduce(1L, (x, y) -> x*(y+1)).intValue() - 1;
    }
}
