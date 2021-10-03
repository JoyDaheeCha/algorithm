package com.example.algorithm.programmers.stackqueue;

import com.example.algorithm.programmers.bfsdfs.TargetNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DevelopmentTest {

    @Test
    void test_case1() {
        // given
        int[] progresses = {93, 30, 55};
        int[] speeds = {1,30,5};

        // when
        Development development = new Development();
        int[] answer = {2, 1};

        // then
        assertThat(development.solution(progresses, speeds)).isEqualTo(answer);
    }
}