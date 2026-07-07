package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 도둑질13 {

    static int[] dp1;
    static int[] dp2;
    static int n;

    public static int solution(int[] money){
        n = money.length;

        dp1 = new int[n];
        dp2 = new int[n];

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


        int answer = 0;
        answer = Math.max(dp1[n-2], dp2[n-1]);

        return answer;

    }

    public static void main(String[] args) throws Exception{
        int[] money = {1,2,3,1};
        System.out.println(solution(money));
    }

}
