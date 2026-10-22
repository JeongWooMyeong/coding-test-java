package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 말이되고픈원숭이6 {

    static int K,W,H;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[] hx = {-1,-2,-2,-1,1,2,2,1};
    static int[] hy = {-2,-1,1,2,2,1,-1,-2};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];

        for(int i=0;i<H;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<W;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());

    }

    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[H][W][K+1];
        q.offer(new int[]{0,0,K,0});
        visited[0][0][K] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int horseCount = cur[2];
            int count = cur[3];

            if(x == H-1 && y == W-1) return count;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if(map[nx][ny] == 1) continue;

                if(!visited[nx][ny][horseCount]){
                    visited[nx][ny][horseCount] = true;
                    q.offer(new int[]{nx,ny,K,count+1});
                }

            }

            if(horseCount > 0){
                for(int i=0;i<8;i++){
                    int nx = x + hx[i];
                    int ny = y + hy[i];

                    if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                    if(map[nx][ny] == 1) continue;

                    if(!visited[nx][ny][horseCount-1]){
                        visited[nx][ny][horseCount-1] = true;
                        q.offer(new int[]{nx,ny,horseCount-1,count+1});
                    }

                }
            }

        }

        return -1;
    }

}
