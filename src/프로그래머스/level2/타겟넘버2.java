package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 타겟넘버2 {
    static int answer = 0;

    public static int solution(int[] numbers, int target){
        dfs(0, 0, numbers, target);

        return answer;
    }

    static void dfs(int idx, int result, int[] numbers, int target){
        if(idx == numbers.length) {
            if (result == target) {
                answer++;
                //return;
            }
            return;
        }

        //if(idx == numbers.length) return;

        //더하는 경우
        dfs(idx+1, result+numbers[idx], numbers, target);
        //빼는 경우
        dfs(idx +1, result-numbers[idx], numbers, target);
    }

    public static void main(String[] args) throws Exception{
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        System.out.println(solution(numbers,target));
    }

}
