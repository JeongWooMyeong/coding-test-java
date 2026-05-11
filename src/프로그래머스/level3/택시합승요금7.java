package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 택시합승요금7 {
    static int[][] map;
    static int INF = (int) 1e9;

    public static int solution(int n, int s, int a, int b, int[][] fares){
        map = new int[n+1][n+1];
        long answer = Integer.MAX_VALUE;

        for(int i=1;i<=n;i++){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for(int[] f : fares){
            int a1 = f[0];
            int b1 = f[1];
            int cost = f[2];

            map[a1][b1] = Math.min(map[a1][b1], cost);
            map[b1][a1] = Math.min(map[b1][a1], cost);

        }

        //플로이드 워셜 알고리즘
        for(int k=1;k<=n;k++){
            for(int a1=1;a1<=n;a1++){
                for(int b1=1;b1<=n;b1++){
                    if(map[a1][k] != INF && map[k][b1] != INF){
                        map[a1][b1] = Math.min(map[a1][b1], map[a1][k] + map[k][b1]);
                    }
                }
            }
        }

        for(int k=1;k<=n;k++){
            answer = Math.min(answer, (long)map[s][k] + map[a][k] + map[k][b]);
        }

        return (int)answer;

    }

    public static void main(String[] args) throws Exception{
//        int n = 6;
//        int s = 4;
//        int a = 6;
//        int b = 2;
//        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
//

        int n = 7;
        int s = 3;
        int a = 4;
        int b = 1;
        int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};


        System.out.println(solution(n,s,a,b,fares));

    }

}
