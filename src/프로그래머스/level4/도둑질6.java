package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 도둑질6 {
    static int[] dp;
    static int[] dp2;

    public static int solution(int[] money){
        int answer = 0;
        int n = money.length;

        //첫번째 집 털 경우
        dp = new int[n];
        dp[0] = money[0];
        dp[1] = money[0];
        //마지막 집 못터니 n-2 까지
        for(int i=2;i<n-1;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }

        //첫번째 집 털지 않는 경우
        dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = money[1];

        for(int i=2;i<n;i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }

        answer = Math.max(dp[n-2], dp2[n-1]);

        return answer;

    }

    public static void main(String[] args) throws Exception{
        int[] money = {1,2,3,1};
        System.out.println(solution(money));
    }

}
