package com.example.algorithm.programmers.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BiggestNumTest {

    @Test
    void test_6_10_2() {
        //given
        int[] array = {6, 10, 2};
        String answer = "6210";

        //when
        BiggestNum biggestNum = new BiggestNum();
        assertThat(biggestNum.solution(array)).isEqualTo(answer);
    }

    @Test
    void test_3_30_34_5_9(){
        //given
        int[] array = {3, 30, 34, 5, 9};
        String answer = "9534330";

        //when
        BiggestNum biggestNum = new BiggestNum();
        assertThat(biggestNum.solution(array)).isEqualTo(answer);
    }

    @Test
    void test_0_0_0() {
        //given
        int[] array = {0,0,0};
        String answer = "0";

        //when
        BiggestNum biggestNum = new BiggestNum();
        assertThat(biggestNum.solution(array)).isEqualTo(answer);
    }
}