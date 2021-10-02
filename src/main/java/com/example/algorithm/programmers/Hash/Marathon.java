package com.example.algorithm.programmers.Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Marathon {
    public String solution(String[] participant, String[] completion) {
       HashMap<String,Integer> partiNmCount = new HashMap<>();

        // 1. 이름별 참가자 수 카운트
        for (String name : participant) {
            if (!partiNmCount.containsKey(name)) {
                partiNmCount.put(name, 1);
            } else {
                partiNmCount.put(name, partiNmCount.get(name) + 1);
            }
        }

        // 2. 참가자수 - 완주자 수
        for (String name : completion) {
            partiNmCount.put(name, partiNmCount.get(name) - 1);
        }

        // 3. 미완주자 도출
        return partiNmCount.entrySet()
                .stream()
                .filter(person -> Objects.equals(person.getValue(), 1))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse("");
    }
}
