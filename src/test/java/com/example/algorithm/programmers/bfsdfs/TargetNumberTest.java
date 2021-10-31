package com.example.algorithm.programmers.bfsdfs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TargetNumberTest {

    @Test
    void test_case1() {
        // given
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        // when
        TargetNumber exam = new TargetNumber();
        int answer = 5;

        // then
        assertThat(exam.solution(numbers, target)).isEqualTo(answer);
    }
}