package com.example.algorithm.programmers.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IndexHTest {
    @Test
    void test_0_0_0() {
        //given
        int[] array = {3, 0, 6, 1, 5};
        int answer = 3;

        //when
        IndexH indexH = new IndexH();
        assertThat(indexH.solution(array)).isEqualTo(answer);
    }
}