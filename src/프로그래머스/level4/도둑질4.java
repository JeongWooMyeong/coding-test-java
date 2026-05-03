package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 도둑질4 {

    static int[] dp;    //i번째 집까지 털었을때
    static int[] dp2;

    public static int solution(int[] money){
        int answer = 0;
        int n = money.length;

        if(n == 1) return money[0];
        if(n == 2) return Math.max(money[0], money[1]);

        //첫번째 집 털었을때 -> 마지막 집 못텀
        dp = new int[n];
        dp[0] = money[0];   //첫번째 집 텀
        dp[1] = money[0];   //두번째 집 못터므로 그대로

        for(int i=2;i<n-1;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }

        //첫번째 집 안텀 -> 마지막 집 텀
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
