package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 말이되고픈원숭이4 {

    static int K, W, H;
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

        map = new int[W][H];
        visited = new boolean[W][H][K+1];

        for(int i=0;i<W;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<H;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(0,0));
    }

    static int bfs(int sx, int sy){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy,0,0});
        visited[sx][sy][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int horse = cur[2];
            int count = cur[3];

            if(x == W-1 && y == H-1) return count;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
                if(visited[nx][ny][horse]) continue;
                if(map[nx][ny] == 1) continue;

                visited[nx][ny][horse] = true;
                q.offer(new int[]{nx,ny,horse,count+1});

            }

            if(horse < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + hx[i];
                    int ny = y + hy[i];

                    if (nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
                    if(visited[nx][ny][horse+1]) continue;
                    if(map[nx][ny] == 1) continue;

                    visited[nx][ny][horse+1] = true;
                    q.offer(new int[]{nx,ny,horse+1,count+1});

                }
            }

        }
        return -1;
    }

}
