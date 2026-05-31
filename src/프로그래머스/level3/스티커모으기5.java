package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 스티커모으기5 {

    static int[] dp1;
    static int[] dp2;
    static int n;

    public static int solution(int sticker[]){
        int answer = 0;
        n = sticker.length;

        dp1 = new int[n];
        dp2 = new int[n];

        if(n == 1) return sticker[0];

        dp1[0] = sticker[0];
        dp1[1] = sticker[0];

        for(int i=2;i<n-1;i++){
            dp1[i] = Math.max(dp1[i-1] , dp1[i-2] + sticker[i]);
        }

        dp2[0] = 0;
        dp2[1] = sticker[1];

        for(int i=2;i<n;i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }

        answer = Math.max(dp1[n-2], dp2[n-1]);

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] sticker = {1,3,2,5,4};

        System.out.println(solution(sticker));
    }

}
