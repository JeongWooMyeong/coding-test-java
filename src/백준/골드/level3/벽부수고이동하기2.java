package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 벽부수고이동하기2 {
    static int N, M;
    static int[][] arr;
    static boolean[][][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M][2]; //벽안부숨 0 벽 부숨 1

        for(int i =0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int answer = bfs();

        System.out.println(answer);

    }

    static int bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,1,0});
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            int broken = cur[3];

            if(x == N - 1 && y == M - 1){
                return dist;
            }

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                //빈칸
                if(arr[nx][ny] == 0 && !visited[nx][ny][broken]){
                    visited[nx][ny][broken] = true;
                    q.offer(new int[]{nx, ny, dist+1, broken});
                }

                //벽
                if(arr[nx][ny] == 1 && broken == 0 && !visited[nx][ny][1]){
                    visited[nx][ny][1] = true;
                    q.offer(new int[]{nx, ny, dist+1, 1});
                }

            }

        }
        return -1;
    }

}
