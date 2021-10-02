package com.example.algorithm.programmers.hash;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DisguiseTest {

    @Test
    void test1() {
        //given
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        //when
        Disguise disguise = new Disguise();
        int answer = 5;

        //then
        assertThat(disguise.solution(clothes)).isEqualTo(answer);
    }

    @Test
    void test2() {
        //given
        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        //when
        Disguise disguise = new Disguise();
        int answer = 3;

        //then
        assertThat(disguise.solution(clothes)).isEqualTo(answer);
    }

}