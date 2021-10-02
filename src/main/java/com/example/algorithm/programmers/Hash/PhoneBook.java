package com.example.algorithm.programmers.Hash;

import java.util.Arrays;

/**
 * 전화번호 목록
 * 한 번호가 다른 번호의 접두사이면 false, 그렇지 않으면 true 리턴
 *
 * 배운 것: startsWith와 contains의 성능 차이. 접두사만 체크하므로 startsWith가 낫다.
 * 배운것2: 12, 123, 1235 순으로 정렬되므로 다음것만 보면 된다.
* */
public class PhoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length-1; i++) {
            String cur = phone_book[i];
            String next = phone_book[i+1];

            if (next.startsWith(cur)) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
