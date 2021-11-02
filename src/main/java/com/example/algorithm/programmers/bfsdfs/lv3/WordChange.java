package com.example.algorithm.programmers.bfsdfs.lv3;

/**
 * 프로그래머스 lv3. 단어 변환
 *
 * 블로그 풀이: https://velog.io/@hammii/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%8B%A8%EC%96%B4-%EB%B3%80%ED%99%98-java
 */
public class WordChange {
    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"} )); // return 4
    }
    static int answer;
    public static int solution(String begin, String target, String[] words) {
        answer = 0;
        boolean[] visited = new boolean[words.length];

        dfs(begin, target, words, visited, 0);
        return answer;
    }

    static void dfs(String begin, String target, String[] words, boolean[] visited, int sum) {
        if(begin.equals(target)) {
            answer = sum;
            return;
        }

        for(int i=0; i < words.length; i++) {
            if(visited[i]) {
                continue;
            }
            int cnt = 0; // 단어 일치수
            for(int j=0; j < words[i].length(); j++) {
                if(begin.charAt(j) == words[i].charAt(j)) {
                    cnt++;
                }
            }

            if(cnt == target.length()-1) {
                visited[i] = true;
                dfs(words[i], target, words, visited, sum+1);
                visited[i] = false;
            }
        }
    }
}
