package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
틀린 코드
말이동, 원숭이 이동 다르게 생각해야함..
 */

public class 말이되고픈원숭이 {

    static int K, W, H;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0,-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {0,1,0,-1,-2,-1,1,2,2,1,-1,-2};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H][W];
        for(int i=0;i<H;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<W;j++){
                board[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        int answer = 0;
        answer = bfs(0,0);

        System.out.println(answer);

    }

    static int bfs(int sx, int sy){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[H][W];
        visited[sx][sy] = true;
        q.offer(new int[]{sx,sy,0,0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            if(x == H-1 && y == W-1 && count == K) return count;

            for(int i=0;i<12;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if(visited[nx][ny]) continue;

                if(board[nx][ny] == 0){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny,count+1});
                }
            }

        }

        return -1;

    }

}
