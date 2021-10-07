package com.example.algorithm.boj.simulation;

import java.io.*;

public class Boj2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int currentHour = Integer.parseInt(input[0]);
        int currentMinute = Integer.parseInt(input[1]);

        boolean needToSubtract1Hour = isNeedToSubtract1Hour(currentMinute);

        String result = newHour(currentHour, needToSubtract1Hour) + " " + newMinute(currentMinute, needToSubtract1Hour);

        System.out.println(result);

    }

    private static boolean isNeedToSubtract1Hour(int currentMinute) {
        return currentMinute - 45 < 0;
    }

    private static int newHour(int currentHour, boolean needToSubtract1Hour) {
        if(needToSubtract1Hour) {
            if(isNeedToAdd24Hours(currentHour)) {
                return (currentHour - 1) + 24;
            }
            return currentHour - 1;
        }

        return currentHour;
    }

    private static boolean isNeedToAdd24Hours(int currentHour) {
        return currentHour -1 < 0;
    }

    private static int newMinute(int currentMinute, boolean needToSubtract1Hour) {
        if(needToSubtract1Hour) {
            return (currentMinute - 45) + 60;
        }

        return currentMinute - 45;
    }
}
