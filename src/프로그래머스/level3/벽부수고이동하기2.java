package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 벽부수고이동하기2 {

    static int N,M;
    static int[][] board;
    static boolean[][][] visited;
    static int answer;
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

        answer = 0;
        answer = bfs(0,0);

        System.out.println(answer);

    }

    static int bfs(int sx, int sy){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy,0,1});
        visited = new boolean[N][M][2];
        visited[sx][sy][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int broken = cur[2];
            int count = cur[3];

            if(x == N-1 && y == M-1) return count;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(board[nx][ny] == 0 && !visited[nx][ny][broken]){
                    visited[nx][ny][broken] = true;
                    q.offer(new int[]{nx,ny,broken,count+1});
                }

                if(board[nx][ny] == 1 && broken == 0 && !visited[nx][ny][1]){
                    visited[nx][ny][1] = true;
                    q.offer(new int[]{nx,ny,1,count+1});
                }

            }

        }


        return -1;
    }

}
