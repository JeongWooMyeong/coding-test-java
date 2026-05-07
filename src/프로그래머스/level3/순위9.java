package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 순위9 {
    static boolean[][] map;

    public static int solution(int n, int[][] results){
        int answer = 0;
        map = new boolean[n+1][n+1];
        //1. 순위 정보 담기
        for(int[] r : results){
            int a = r[0];
            int b = r[1];
            map[a][b] = true;
            //map[b][a] = true;
        }
        //2. 플로이드 워셜 알고리즘
        for(int k=1;k<=n;k++){
            for(int a=1;a<=n;a++){
                for(int b=1;b<=n;b++){
                    if(map[a][k] && map[k][b]) map[a][b] = true;
                }
            }
        }

        //3. 순위 확인
        for(int i=1;i<=n;i++){
            int count = 0;
            for(int j=1;j<=n;j++){
                if(map[i][j] || map[j][i]) count++;
            }
            if(count == n-1) answer++;
        }




        return answer;
    }

    public static void main(String[] args) throws Exception{
        int n = 5;
        int[][] results = {{4,3,},{4,2},{3,2},{1,2},{2,5}};
        System.out.println(solution(n, results));
    }

}
