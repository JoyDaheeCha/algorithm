package com.example.algorithm.programmers.bfsdfs;

public class TargetNumber {
    //1. 답안은 전역 변수 설정
    static int answer;

    public void dfs(int[] numbers, int target, int idx, int sum) {
        //2. numbers 마지막까지 탐색 완료했을 때
        if(idx == numbers.length) {
            //3. target과 일치할 경우 리턴
            if(target == sum) {
                answer++;
            }
            return;
        }

        //4. 현재 인덱스 정수 더하기
        sum+=numbers[idx];
        //5. 다음 인덱스 dfs 실행
        dfs(numbers, target, idx+1, sum);
        //6. 4의 값을 다시 빼준다
        sum-=numbers[idx];
        //7. 현재 인덱스 정수를 -로 더한다.
        sum-=numbers[idx];
        //8. 다시 다음 인덱스 dfs 실행
        dfs(numbers, target, idx+1, sum);
    }

    public int solution(int[] numbers, int target) {
        answer = 0;

        dfs(numbers, target, 0, 0);
        return answer;
    }
}
