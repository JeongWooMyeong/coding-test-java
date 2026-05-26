package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 도둑질7 {
    static int[] dp1;
    static int[] dp2;

    public static int solution(int[] money){
        dp1 = new int[money.length];
        dp2 = new int[money.length];
        int n = money.length;

        int answer = 0;

        //첫번째 집을 털때 -> 마지막 집 못털음
        dp1[0] = money[0];
        dp1[1] = money[0];

        for(int i=2;i<n-1;i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }

        dp2[0] = 0;
        dp2[1] = money[1];

        for(int i=2;i<n;i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }


        answer = Math.max(dp1[n-2], dp2[n-1]);


        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] money = {1,2,3,1};
        System.out.println(solution(money));
    }

}
