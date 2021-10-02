package com.example.algorithm.programmers.sort;

import java.util.Arrays;

/**
 * 프로그래머스 > 정렬 > H-Index
* */
public class IndexH {
    public int solution(int[] citations) {
        int hIdx = citations.length;

        while(true) {
            int finalH = hIdx;
            int citationCnt = (int) Arrays.stream(citations)
                                    .filter(citation -> citation >= finalH)
                                    .count();
            if(hIdx <= citationCnt) {
                break;
            }

            hIdx--;
        }
        return hIdx;
    }
}
