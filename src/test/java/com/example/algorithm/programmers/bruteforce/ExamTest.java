package com.example.algorithm.programmers.bruteforce;

import com.example.algorithm.programmers.greedy.JoggingSuit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExamTest {

    @Test
    void test_case1() {
        // given
        int[] answers = {1,2,3,4,5};
        int[] students = {1};

        // when
        Exam exam = new Exam();

        // then
        assertThat(exam.solution(answers)).isEqualTo(students);
    }
}