package com.example.algorithm.programmers.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberKTest {
    @Test
    void test1() {
        //given
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = {5, 6, 3};

        //when
        NumberK numberK = new NumberK();
        assertThat(numberK.solution(array, commands)).isEqualTo(answer);
    }
}