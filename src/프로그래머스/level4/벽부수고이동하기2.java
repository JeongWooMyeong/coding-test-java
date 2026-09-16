package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 벽부수고이동하기2 {

    static int N,M,K;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][K+1];

        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));

    }

    static int bfs(int sx, int sy){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy,K,1});
        visited[sx][sy][K] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int brokenCount = cur[2];
            int cost = cur[3];

            if(x == N-1 && y == M-1) return cost;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(brokenCount > 0 && map[nx][ny] == 1 && !visited[nx][ny][brokenCount-1]){
                    visited[nx][ny][brokenCount-1] = true;
                    q.offer(new int[]{nx,ny,brokenCount-1,cost+1});
                }

                if(map[nx][ny] == 0 && !visited[nx][ny][brokenCount]){
                    visited[nx][ny][brokenCount] = true;
                    q.offer(new int[]{nx,ny,brokenCount,cost+1});
                }

            }
        }

        return -1;
    }

}
