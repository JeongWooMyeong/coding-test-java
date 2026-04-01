package 이것이코딩테스트다2.기출문제.다이내믹프로그래밍;

import java.util.*;

public class 퇴사 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] dp = new int[N+2];    //N+1까지 고려

        for(int i=1;i<=N;i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        //뒤에서부터 계산
        for(int i=N;i>=1;i--){
            if(i + T[i] <= N+1){
                dp[i] = Math.max(P[i] + dp[i+T[i]], dp[i+1]);
            }else{
                dp[i] = dp[i+1];
            }
        }

        System.out.println(dp[1]);

    }
}
