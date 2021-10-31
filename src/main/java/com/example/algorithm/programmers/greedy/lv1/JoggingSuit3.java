package com.example.algorithm.programmers.greedy.lv1;

/**
 * 체육복 lv3
 * Time Complexity : O(n)
 * 다른 사람 풀이에서 아이디어 얻음.
 * -> people array에서 학생의 체육복 보유 여부 관리
* */
class JoggingSuit3 {
    public int solution(int n, int[] lost, int[] reserve) {
        int stuCnt = n;
        int[] people = new int[n+1];


        for(int i = 0; i < lost.length; i++) {
            people[lost[i]] -= 1;
        }


        for(int i = 0; i < reserve.length; i++) {
            people[reserve[i]] += 1;
        }

        for(int i = 1; i < people.length; i++) {
            // 1. 도난 된 경우
            if(people[i] == -1) {

                if(i != 1 && people[i-1] > 0) {
                    people[i] += 1;
                    people[i-1] -= 1;

                } else if(i != people.length-1 && people[i+1] > 0) {
                    people[i] += 1;
                    people[i+1] -= 1;

                } else {
                    stuCnt--;
                }
            }
            // 수업 받을 수 있음.
        }

        return stuCnt;
    }
}