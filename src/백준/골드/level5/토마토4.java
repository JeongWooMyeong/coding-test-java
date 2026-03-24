package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 토마토4 {
    static int N,M,H;
    static int[][][] arr;

    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        Queue<int[]> q = new ArrayDeque<>();

        for(int h=0;h<H;h++){
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    arr[h][i][j] = Integer.parseInt(st.nextToken());
                    if(arr[h][i][j] == 1){
                        q.offer(new int[]{h,i,j});
                    }
                }

            }
        }

        int days = bfs(q);

        for(int h=0;h<H;h++){
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(arr[h][i][j] == 0){
                        System.out.print(-1);
                        return;
                    }
                }
            }
        }

        System.out.print(days);


    }

    static int bfs(Queue<int[]> q){
        int days = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int s=0;s<size;s++) {
                int[] cur = q.poll();
                int z = cur[0];
                int x = cur[1];
                int y = cur[2];

                for (int i = 0; i < 6; i++) {
                    int nz = z + dz[i];
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nz < 0 || nx < 0 || ny < 0 || nz >= H || nx >= N || ny >= M) continue;

                    if (arr[nz][nx][ny] == 0) {
                        arr[nz][nx][ny] = 1;
                        q.offer(new int[]{nz, nx, ny});
                    }

                }
            }
            if(!q.isEmpty()) days++;
        }
        return days;
    }

}
