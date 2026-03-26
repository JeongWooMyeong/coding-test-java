package 백준.골드.level4;

import java.util.*;

public class 로또 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();

            long[][] dp = new long[n+1][m+1];
            //초기값 아무것도 안뽑으면 경우의 수 1
            for(int j=0;j<=m;j++) dp[0][j] = 1;

            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    //마지막 숫자 j를 선택하냐 선택하지 않냐
                    // j를 선택하지 않으면 j-1
                    // j선택했으면 j/ 2이하에서 뽑아야 하지 조건때문에?
                    dp[i][j] = dp[i][j-1] + dp[i-1][j/2];   //i
                }
            }

            System.out.println(dp[n][m]);

        }
    }
}
