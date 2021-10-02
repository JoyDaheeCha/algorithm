package com.example.algorithm.programmers.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BiggestNumTest {

    @Test
    void test1() {
        //given
        int[] array = {6, 10, 2};
        String answer = "6210";

        //when
        BiggestNum biggestNum = new BiggestNum();
        assertThat(biggestNum.solution(array)).isEqualTo(answer);
    }

    @Test
    void test2() {
        //given
        int[] array = {3, 30, 34, 5, 9};
        String answer = "9534330";

        //when
        BiggestNum biggestNum = new BiggestNum();
        assertThat(biggestNum.solution(array)).isEqualTo(answer);
    }
}