package com.example.algorithm.nadongbin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Greedy1 {
    public static int n;
    public static ArrayList<Integer> mems = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            mems.add(sc.nextInt());
        }

        Collections.sort(mems);

        int groupCnt = 0; // 모험가 그룹 수
        int memCnt = 0; // 현재 그룹의 모험가 수

        for (int i = 0; i < n; i++) {
            memCnt++;
            if(memCnt >= mems.get(i)) {
                groupCnt++;
                memCnt = 0; // 다음 그룹을 위해, 멤버 수 초기화
            }
        }

        System.out.println(groupCnt);
    }
}
