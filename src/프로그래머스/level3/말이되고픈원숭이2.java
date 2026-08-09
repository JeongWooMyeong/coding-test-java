package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 말이되고픈원숭이2 {

    static int K,W,H;
    static boolean[][][] visited;
    static int answer;
    static int[][] board;
    static int[] dx4 = {-1,0,1,0};
    static int[] dy4 = {0,1,0,-1};
    static int[] dx8 = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy8 = {-2,-1,1,2,2,1,-1,-2};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        answer = 0;
        board = new int[H][W];

        for(int i=0;i<H;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<W;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = bfs(0,0);

        System.out.println(answer);

    }

    static int bfs(int sx, int sy){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[H][W][K+1];
        q.offer(new int[]{sx,sy,0,0});
        visited[sx][sy][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int horse = cur[2];
            int dist = cur[3];

            if(x == H-1 && y == W-1) return dist;

            for(int i=0;i<4;i++){
                int nx = x + dx4[i];
                int ny = y + dy4[i];

                if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if(visited[nx][ny][horse]) continue;

                if(board[nx][ny] == 0){
                    visited[nx][ny][horse] = true;
                    q.offer(new int[]{nx,ny,horse,dist+1});
                }
            }

            if(horse < K){
                for(int i=0;i<8;i++){
                    int nx = x + dx8[i];
                    int ny = y + dy8[i];

                    if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                    if(visited[nx][ny][horse+1]) continue;

                    if(board[nx][ny] == 0){
                        visited[nx][ny][horse+1] = true;
                        q.offer(new int[]{nx,ny,horse+1,dist+1});
                    }

                }
            }

        }
        return -1;
    }

}
