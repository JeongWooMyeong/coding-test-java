package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 벽부수고이동하기 {

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
            int brokencnt = cur[2];
            int count = cur[3];

            if(x == N-1 && y == M-1) return count;


            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(brokencnt > 0 && !visited[nx][ny][brokencnt-1] && map[nx][ny] == 1){
                    visited[nx][ny][brokencnt-1] = true;
                    q.offer(new int[]{nx,ny,brokencnt-1,count+1});
                }

                if(!visited[nx][ny][brokencnt] && map[nx][ny] == 0){
                    visited[nx][ny][brokencnt] = true;
                    q.offer(new int[]{nx,ny,brokencnt,count+1});
                }

            }

        }

        return -1;
    }

}
