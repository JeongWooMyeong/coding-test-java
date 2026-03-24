package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 토마토3 {
    static int N,M;
    static int[][] board;
    static boolean[][] visited;
    static int days = 0;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1){
                    q.offer(new int[]{i,j});
                }
            }
        }

        days = bfs(q);

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.print(days);


    }

    static int bfs(Queue<int[]> q){
        //visited[a][b] = true;
        int days = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int s=0;s<size;s++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        continue;
                    }
                    if (board[nx][ny] == -1) continue;

                    if (board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        //visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }

                }
            }
            if(!q.isEmpty()) days++;
        }
        return days;
    }

}
