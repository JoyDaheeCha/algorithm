package com.example.algorithm.programmers.greedy;

import com.example.algorithm.programmers.greedy.JoggingSuit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JoggingSuitTest {

    @Test
    void test_case1() {
        // given
        int n = 5;
        int[] losts = new int[]{2,4};
        int[] reserves = new int[]{1,3,5};

        // when
        JoggingSuit joggingSuit = new JoggingSuit();

        // then
        assertThat(joggingSuit.solution(n, losts, reserves)).isEqualTo(5);
    }

    @Test
    void test_case2() {
        // given
        int n = 5;
        int[] losts = new int[]{2,4};
        int[] reserves = new int[]{3};

        // when
        JoggingSuit joggingSuit = new JoggingSuit();

        // then
        assertThat(joggingSuit.solution(n, losts, reserves)).isEqualTo(4);
    }

    @Test
    void test_case3() {
        // given
        int n = 3;
        int[] losts = new int[]{3};
        int[] reserves = new int[]{1};

        // when
        JoggingSuit joggingSuit = new JoggingSuit();

        // then
        assertThat(joggingSuit.solution(n, losts, reserves)).isEqualTo(2);
    }

}