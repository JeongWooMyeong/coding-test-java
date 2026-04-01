package 이것이코딩테스트다2.기출문제.다이내믹프로그래밍;

import java.util.*;

public class 병사배치하기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] soldiers = new int[N];
        for(int i=0;i<N;i++){
            soldiers[i] = sc.nextInt();
        }

        //배열을 뒤집어서 LIS 문제로 변환
        int[] reversed = new int[N];
        for(int i=0;i<N;i++){
            reversed[i] = soldiers[N - 1 - i];
        }

        //LIS 점화식
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        int maxLen = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<i;j++){
                if(reversed[j] < reversed[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        //최소 열외 병사수 = 전체 - LIS 길이
        int result = N - maxLen;
        System.out.println(result);

    }
}
