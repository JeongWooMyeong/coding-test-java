package 이것이코딩테스트다2.기출문제.다이내믹프로그래밍;

import java.util.*;

public class 퇴사2 {
    static int N;
    static int[] T, P;
    static Integer[] dp;    //메모이제이션

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        T = new int[N+1];
        P = new int[N+1];
        dp = new Integer[N+2];

        for(int i=1;i<=N;i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        System.out.println(solve(1));
    }

    static int solve(int day){
        if(day > N) return 0;   //퇴사일 이후에는 ㅅ ㅜ익 없음
        if(dp[day] != null) return dp[day]; //이미 계산된 값 있으면 반환

        int take = 0;
        if(day + T[day] <= N+1){
            take = P[day] + solve(day + T[day]);
        }
        int skip = solve(day + 1);

        dp[day] = Math.max(take, skip);
        return dp[day];
    }
}
