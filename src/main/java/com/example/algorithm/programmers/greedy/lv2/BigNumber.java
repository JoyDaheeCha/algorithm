package com.example.algorithm.programmers.greedy.lv2;

import java.util.*;

/**
 * 내가 시도한 방법. (각 숫자별로 index를 기억한다)
 * "4177252841", 4 에서 반례 생김
 * 예상 값 : 775841
 * 실행 결과: 477584
 *
 *  무조건 작은 수를 지운다는 가정이 잘못 됨.
 */
public class BigNumber {
    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
    }
    public static String solution(String number, int k) {
       char[][] given = new char[number.length()][2];

        for(int i=0; i < number.length(); i++) {
            given[i][0] = number.charAt(i);
            given[i][1] = (char) i;
        }

        Arrays.sort(given, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        char[][] mod = Arrays.copyOfRange(given, k, given.length);

        Arrays.sort(mod, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }else {
                return o1[1] - o2[1];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (char[] item : mod) {
            sb.append(item[0]);
        }
        return sb.toString();
    }
}
