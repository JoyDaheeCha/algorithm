package com.example.algorithm.programmers.heap;

import com.example.algorithm.programmers.hash.Disguise;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpicyTest {
    @Test
    void test1() {
        //given
        int[] scoville = {10, 12, 3, 9, 1, 2};
        int k = 7;

        //when
        Spicy spicy = new Spicy();
        int answer = 2;

        //then
        assertThat(spicy.solution(scoville, k)).isEqualTo(answer);
    }
}