package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 도둑질5 {
    static int[] dp;    //첫번째 집을 터는 경우
    static int[] dp2;   //두번째 집을 터는 경우

    public static int solution(int[] money){
        int answer = 0;
        dp = new int[money.length];
        dp2 = new int[money.length];
        int n = money.length;
        //첫번째 집을 터는 경우
        dp[0] = money[0];
        dp[1] = money[0];

        for(int i=2;i<n-1;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }

        //첫번째 집을 털지 않은 경우
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
