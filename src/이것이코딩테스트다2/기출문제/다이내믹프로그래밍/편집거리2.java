package 이것이코딩테스트다2.기출문제.다이내믹프로그래밍;

import java.util.*;
import java.io.*;

public class 편집거리2 {
    static int N, M;
    static String A,B;
    static int[][] dp;  //앞글자 i, 앞글자 j 비교

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        B = br.readLine();

        N = A.length(); //A문자열 길이
        M = B.length(); //B문자열 길이
        //빈 문자열도 생각해야하기 때문 dp 에서
        //입력은 길이 1이상이지만 dp에서는 빈문자열 고려해야함
        dp = new int[N+1][M+1];
        //B가 빈문자열일때 A에서는 빈문자열 만들기 위해 삭제 해야함
        for(int i=0;i<=N;i++) dp[i][0] = i;
        //A가 빈문자열일때 B를 만들기 위해 삽입해야함
        for(int j=0;j<=M;j++) dp[0][j] = j;

        //문자열 비교 1부터 비교 (0은 빈문자열 했기 때문ㅇ)
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    //문자열 끝자리 같으면 바꿀 필요 없음
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    //다르면 3가지 연산 시도 중 최소 횟수 구하기
                    int insert = dp[i][j-1] + 1;
                    int remove = dp[i-1][j] + 1;
                    int replace = dp[i-1][j-1] + 1;

                    dp[i][j] = Math.min(insert, Math.min(remove, replace));
                }
            }
        }

        System.out.print(dp[N][M]);

    }

}
