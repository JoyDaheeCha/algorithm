package com.example.algorithm.programmers.Hash;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneBookTest {
    @Test
    void test1() {
        //given
        String[] given = new String[]{"119", "97674223", "1195524421"};

        //when
        PhoneBook phoneBook = new PhoneBook();

        //then
        assertThat(phoneBook.solution(given)).isFalse();
    }
}