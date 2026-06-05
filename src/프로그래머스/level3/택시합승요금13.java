package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
플로이드 워셜
 */

public class 택시합승요금13 {

    static int[][] map;
    static int INF = (int) 1e9;

    public static int solution(int n, int s, int a, int b, int[][] fares){

        long answer = Integer.MAX_VALUE;
        map = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for(int[] f : fares){
            int from = f[0];
            int to = f[1];
            int cost = f[2];

            map[from][to] = Math.min(map[from][to], cost);
            map[to][from] = Math.min(map[to][from], cost);

        }

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
        int n = 6;
        int s = 4;
        int a = 5;
        int b = 6;
        int[][] fares = {{2,6,6},{6,3,7},{4,6,7},{6,5,11},{2,5,12},{5,3,20},{2,4,8},{4,3,9}};

        System.out.println(solution(n,s,a,b,fares));
    }


}
