package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
처음 강제선택 하거나 안할때로 난 짬 (도둑질과 비슷)

 */

public class 스티커모으기 {

    public static int solution(int sticker[]){
        int n = sticker.length;
        int answer = 0;
        //n이 하나일때는 sticker[0] 반환
        if(n == 1) return sticker[0];

        //1. 처음 스티커를 사용할때 -> 원형이므로 마지막 스티커는 사용 못함
        int[] dp = new int[n];
        dp[0] = sticker[0];
        //dp[1] = Math.max(sticker[1], sticker[0]);
        dp[1] = sticker[0];

        for(int i=2;i<n-1;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
        }


        //2. 처음 스티커를 사용하지 않을때 -> 원형이므로 마지막 스티커 사용 가능
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = sticker[1];

        for(int i=2;i<n;i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] +sticker[i]);
        }


        answer = Math.max(dp[n-2], dp2[n-1]);

        return answer;

    }

    public static void main(String[] args) throws Exception{
        int[] sticker = {14,6,5,11,3,9,2,10};

        System.out.println(solution(sticker));
    }

}
