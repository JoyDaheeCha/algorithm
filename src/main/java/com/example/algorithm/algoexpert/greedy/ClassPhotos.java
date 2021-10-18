package com.example.algorithm.algoexpert.greedy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * algoexpert.io
 * 스스로 풀었음 : o
 * time complexity: O(1) (=number of queries)
 *
 * 놓쳤던 부분: 앞 줄은 항상 작아야한다 -> 가장 키가 작은 학생들끼리 비교해서, 키가 더 작은 학생이 속한 그룹을 앞 줄에 세운 후 테스트 진행하면 된다.
 * */
public class ClassPhotos {
    public static void main(String[] args) {
        ArrayList<Integer> redShirtHeights = new ArrayList<>(Arrays.asList(5,8,1,3,4));
        ArrayList<Integer> blueShirtHeights = new ArrayList<>(Arrays.asList(6,9,2,4,5));
        System.out.println(classPhotos(redShirtHeights, blueShirtHeights));
    }

    public static boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        // 1. 키 오름차순 정렬
        redShirtHeights.sort(Integer::compare);
        blueShirtHeights.sort(Integer::compare);

        // 2. 빨간 옷 학생이 뒤에 설 경우 or 파란 옷 학생이 뒤에 설 경우
        return isBackAllTallerThanFront(redShirtHeights, blueShirtHeights) || isBackAllTallerThanFront(blueShirtHeights, redShirtHeights);
    }

    private static boolean isBackAllTallerThanFront(ArrayList<Integer> back, ArrayList<Integer> front) {
        boolean allTaller = true; // 뒷 줄 학생이 모두 큰 경우
        for (int i = 0; i < back.size(); i++) {
            if(back.get(i) <= front.get(i)) {
                allTaller = false;
                break;
            }
        }
        return allTaller;
    }
}
