package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 미로탐색 {

    static boolean[][] visited;
    static int N,M;
    static int[][] board;
    static int[][] dist;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<M;j++){
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int answer = 0;
        answer = bfs(0, 0, N-1, M-1);

        System.out.println(answer);
    }

    static int bfs(int sx, int sy, int ex, int ey){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N][M];
        dist = new int[N][M];

        q.offer(new int[]{sx,sy});
        visited[sx][sy] = true;
        dist[sx][sy] = 1;   //시작 위치 포함

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if(x == ex && y == ey) return dist[x][y];
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(visited[nx][ny]) continue;

                if(board[nx][ny] == 1){
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx,ny});
                }


            }
        }

        return -1;
    }

}
