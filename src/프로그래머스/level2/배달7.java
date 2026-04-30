package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 배달7 {
    static int[][] map;
    static int INF = (int) 1e9;

    public static int solution(int N, int[][] road, int K){
        int answer = 0;
        map = new int[N+1][N+1];

        for(int i=0;i<=N;i++){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for(int[] r : road){
            int from = r[0];
            int to = r[1];
            int cost = r[2];

            map[from][to] = Math.min(map[from][to], cost);
            map[to][from] = Math.min(map[to][from], cost);

        }

        for(int k=1;k<=N;k++){
            for(int a=1;a<=N;a++){
                for(int b=1;b<=N;b++){
                    if(map[a][k] != INF && map[k][b] != INF) {
                        map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
                    }
                }
            }
        }

        for(int k=1;k<=N;k++){
            if(map[1][k] <= K){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;

        System.out.println(solution(N, road, K));
    }

}
