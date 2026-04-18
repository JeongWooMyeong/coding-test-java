package 프로그래머스.level4;

import java.util.*;
import java.io.*;

/*
내가 지금 생각해서 푼것은 선형일때는 가능
근데 지금 문제는 원형이므로 경우를 더 생각해야함
X
 */

public class 도둑질 {
    static int[] dp;

    public static int solution(int[] money){
        int answer = 0;

        dp = new int[money.length];
        int n = money.length;
        //첫번째 집 턴 경우
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }

        for(int i=0;i<n;i++){
            answer = Math.max(answer, dp[i]);
        }


        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] money = {1,2,3,1};
        System.out.println(solution(money));
    }

}
