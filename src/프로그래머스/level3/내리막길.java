package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 내리막길 {
    static int[][] dp;
    static int[][] map;
    static int M,N;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dp = new int[M][N];
        map = new int[M][N];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;  //dp 초기화
            }
        }

        System.out.println(dfs(0,0));

    }

    static int dfs(int x, int y){
        if(x == N-1 && y == M-1) return 1;
        if(dp[y][x] != -1) return dp[y][x];
        //이제부터 경로를 누적한다?
        dp[y][x] = 0;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            if(map[y][x] > map[ny][nx]){
                dp[y][x] += dfs(nx,ny);
            }

        }

        return dp[y][x];

    }

}
