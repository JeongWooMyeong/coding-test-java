package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 도둑질3 {
    public static int solution(int[] money){
        int answer = 0;
        int[] dp = new int[money.length];
        int[] dp2 = new int[money.length];

        //1. 첫번째 집 털 경우 -> 마지막 집 못털음 (원형 구조 떄문에)
        dp[0] = money[0];
        dp[1] = money[0];

        for(int i=2;i<money.length-1;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }

        //2. 첫번째 안털음
        dp2[0] = 0;
        dp2[1] = money[1];

        for(int i=2;i<money.length;i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }


        answer = Math.max(dp[money.length-2], dp2[money.length-1]);

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] money = {1,2,3,1};
        System.out.println(solution(money));
    }

}
