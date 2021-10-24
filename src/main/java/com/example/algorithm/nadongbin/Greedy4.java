package com.example.algorithm.nadongbin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Greedy4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> given = new ArrayList<>();

        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            given.add(sc.nextInt());
        }

        Collections.sort(given);

        int target = 1;
        for(int i=0; i < n; i++) {
            if(target < given.get(i)) break;
            target += given.get(i);
        }

        System.out.println(target);
    }
}
