package com.example.algorithm.programmers.Hash;

import com.example.algorithm.programmers.Hash.Marathon;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MarathonTest {

    @Test
    void test1() {
        //given
        String[] participant = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"eden", "kiki"};

        //when
        Marathon marathon = new Marathon();

        //then
        assertThat(marathon.solution(participant, completion)).isEqualTo("leo");
    }

}