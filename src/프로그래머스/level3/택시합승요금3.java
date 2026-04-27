package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 택시합승요금3 {
    static int[][] map;
    static int INF = (int) 1e9;

    public static int solution(int n, int s, int a, int b, int[][] fares){
        long answer = Long.MAX_VALUE;

        map = new int[n+1][n+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(map[i], INF);
            //자기 자신으로 가는 길 초기화
            map[i][i] = 0;
        }


        for(int[] fare : fares){
            int x = fare[0];
            int y = fare[1];
            int cost = fare[2];

            map[x][y] = Math.min(map[x][y], cost);
            map[y][x] = Math.min(map[y][x], cost);

        }


        for(int k=1;k<=n;k++){
            for(int x=1;x<=n;x++){
                for(int y=1;y<=n;y++){
                    if(map[x][k] != INF && map[k][y] != INF){
                        map[x][y]= Math.min(map[x][y], map[x][k] + map[k][y]);
                    }
                }
            }
        }

        for(int k=1;k<=n;k++){
            answer = Math.min(answer,(long) map[s][k] + map[a][k] + map[k][b]);
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
