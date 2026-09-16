package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 알고스팟2 {

    static int M,N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));

    }

    static int bfs(int sx, int sy){
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{sx,sy,0});
        visited[sx][sy] = true;

        while(!dq.isEmpty()){
            int[] cur = dq.pollFirst();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            if(x == N-1 && y == M-1) return count;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;

                if(map[nx][ny] == 1){
                    dq.addLast(new int[]{nx,ny,count+1});
                }else{
                    dq.addFirst(new int[]{nx,ny,count});
                }


            }

        }

        return -1;
    }

}
