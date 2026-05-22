package 프로그래머스.level2;

import java.util.*;
import java.io.*;


/*
플로이드 워셜 알고리즘
N = 50 까지라 가능
N = 200 이상 되면 다익스트라 필수
N^3 이기 때문에 for문 3중
 */

public class 배달17 {

    static int[][] map;
    static int INF = (int) 1e9;

    public static int solution(int N, int[][] road, int K){
        int answer = 0;

        map = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for(int[] r : road){
            int a = r[0];
            int b = r[1];
            int cost = r[2];

            map[a][b] = Math.min(map[a][b], cost);
            map[b][a] = Math.min(map[b][a], cost);

        }

        for(int k=1;k<=N;k++){
            for(int a=1;a<=N;a++){
                for(int b=1;b<=N;b++){
                    if(map[a][k] != INF && map[k][b] != INF){
                        map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
                    }
                }
            }
        }


        for(int i=1;i<=N;i++){
            if(map[1][i] <= K){
                answer++;
            }
        }



        return answer;

    }

    public static void main(String[] args) throws Exception{
        int N = 6;
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        int K = 4;

        System.out.println(solution(N, road, K));
    }

}
