package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 순위2 {
    //관계를 알수 있냐 없나 boolean
    static boolean[][] map;

    public static int solution(int n, int[][] results){
        map = new boolean[n+1][n+1];

        for(int[] r : results){
            int a = r[0];
            int b = r[1];

            map[a][b] = true;
        }

        //플로이드 워셜로 모든 경우의 쌍 구하기
        for(int k=1;k<=n;k++){
            for(int a=1;a<=n;a++){
                for(int b=1;b<=n;b++){
                    if(map[a][k] && map[k][b]){
                        map[a][b] = true;
                    }
                }
            }
        }

        int answer = 0;
        //개수 구하기
        for(int i=1;i<=n;i++){
            int count = 0;
            for(int j=1;j<=n;j++){
                if(map[i][j] || map[j][i]) count++;
            }
            //자기 자신 제외
            if(count == n-1) answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int n = 5;
        int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};

        System.out.println(solution(n, results));
    }
}
