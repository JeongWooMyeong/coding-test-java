package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 알고스팟3 {

    static int M,N;
    static int[][] map;
    //static boolean[][] visited;
    static int[][] dist;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));

    }

    static int bfs(int sx, int sy){
        Deque<int[]> q = new ArrayDeque<>();
        dist = new int[N][M];

        for(int i=0;i<N;i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        q.addFirst(new int[]{sx,sy});
        dist[sx][sy] = 0;

        while(!q.isEmpty()){
            int[] cur = q.pollFirst();
            int x = cur[0];
            int y = cur[1];

            if(x == N-1 && y == M-1) return dist[x][y];

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                int newCost = dist[x][y] + map[nx][ny];

                if(dist[nx][ny] > newCost){

                    dist[nx][ny] = newCost;

                    if(map[nx][ny] == 1){

                        q.addLast(new int[]{nx,ny});
                    }else{
                        q.addFirst(new int[]{nx,ny});
                    }
                }

            }
        }

        return -1;
    }

}
