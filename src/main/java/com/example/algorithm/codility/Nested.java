package com.example.algorithm.codility;

import java.util.Stack;

/**
 * Codility / Stack / Bracket
 *
 * 주의사항: String 으로 bracket 비교하면 time out 에러남. char로 비교!
* */
public class Nested {
    public static void main(String[] args) {
        System.out.println(solution("{[()()]}")); // 1

        System.out.println(solution("([)()]")); // 0

        System.out.println(solution("")); // 1

        System.out.println(solution(")(")); // 0
    }

    static int solution(String S) {
        if("".equals(S)) {
            return 1;
        }

        Stack<Character> stack = new Stack<>();

        char[] spt = S.toCharArray();

        for (int i = 0; i < spt.length; i++) {
            char cur = spt[i];
            if('(' == cur || '{' == cur || '[' == cur) {
                stack.push(cur);
            }else {
                if(stack.isEmpty()) {
                    return 0;
                }else {
                    char prev = stack.pop();

                    if('(' != prev && ')' == cur) {
                        return 0;
                    } else if('[' != prev && ']' == cur) {
                        return 0;
                    } else if('{' != prev && '}' == cur) {
                        return 0;
                    }
                }
            }
        }
        return stack.isEmpty() ? 1: 0;
    }
}
