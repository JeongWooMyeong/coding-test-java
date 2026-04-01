package 이것이코딩테스트다2.기출문제.다이내믹프로그래밍;

import java.util.*;
import java.io.*;

public class 병사배치하기2 {
    static int N;
    static int[] soldiers;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        soldiers = new int[N];
        dp = new int[N];
        //병사 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            soldiers[i] = Integer.parseInt(st.nextToken());
        }
        //DP 1로 초기화
        Arrays.fill(dp, 1);

        //reverse
        int[] reversed = new int[N];
        for(int i=0;i<N;i++){
            reversed[i] = soldiers[N - 1 - i];
        }

        int maxLen = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<i;j++){
                if(reversed[i] > reversed[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }

        int result = N - maxLen;

        System.out.println(result);

    }

}
