package com.example.algorithm.programmers.bruteforce;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrimeNumberTest {

    @Test
    void test_case1() {
        // given
        String numbers = "17";

        // when
        PrimeNumber primeNumber = new PrimeNumber();
        int answer = 3;

        // then
        assertThat(primeNumber.solution(numbers)).isEqualTo(answer);
    }
}