package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
공통화 하여 품
 */

public class 스티커모으기2 {
    public static int solution(int sticker[]){
        int n = sticker.length;

        if(n == 1) return sticker[0];

        int answer = Math.max(solve(sticker, 0, n-2), solve(sticker, 1, n-1));

        return answer;
    }

    static int solve(int[] arr, int start, int end){
        int len = end - start + 1;
        int[] dp = new int[len];

        dp[0] = arr[start];

        if(len > 1) dp[1] = Math.max(arr[start], arr[start + 1]);

        for(int i=2;i<len;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + arr[start + i]);
        }

        return dp[len-1];

    }

    public static void main(String[] args) throws Exception{
        int[] sticker = {14,6,5,11,3,9,2,10};

        System.out.println(solution(sticker));
    }

}
