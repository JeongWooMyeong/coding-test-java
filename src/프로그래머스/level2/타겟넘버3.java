package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 타겟넘버3 {

    static int answer;

    public static int solution(int[] numbers, int target){
        answer = 0;

        dfs(0, 0,numbers, target);

        return answer;

    }

    static void dfs(int idx, int sum, int[] numbers, int target){
        if(idx == numbers.length){
            if(sum == target){
                answer++;
            }

            return;
        }
        //현재 수 더하기
        dfs(idx+1,sum+numbers[idx], numbers, target);
        //현재 수 빼기
        dfs(idx+1, sum-numbers[idx], numbers, target);

    }

    public static void main(String[] args) throws Exception{
        int[] numbers = {4,1,2,1};
        int target = 4;
        System.out.println(solution(numbers,target));
    }



}
