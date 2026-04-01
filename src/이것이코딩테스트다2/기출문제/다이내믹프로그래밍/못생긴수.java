package 이것이코딩테스트다2.기출문제.다이내믹프로그래밍;

import java.util.*;
import java.io.*;

public class 못생긴수 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n];

        //0일때 첫번째 1
        dp[0] = 1;

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int next2 = 2;
        int next3 = 3;
        int next5 = 5;

        for(int i=1;i<n;i++){
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if(dp[i] == next2){
                i2++;
                next2 = dp[i2] * 2;
            }

            if(dp[i] == next3){
                i3++;
                next3 = dp[i3] * 3;
            }

            if(dp[i] == next5){
                i5++;
                next5 = dp[i5] * 3;
            }
        }

        System.out.print(dp[n-1]);


    }
}
