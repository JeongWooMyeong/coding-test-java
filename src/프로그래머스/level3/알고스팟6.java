package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 알고스팟6 {

    static int N,M;
    static int[][] map;
    static int[][] dists;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<line.length();j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));

    }

    static int bfs(int sx, int sy){
        Deque<int[]> dq = new ArrayDeque<>();
        dists = new int[N][M];
        for(int i=0;i<N;i++) Arrays.fill(dists[i], Integer.MAX_VALUE);
        dists[sx][sy] = 0;
        dq.addFirst(new int[]{sx,sy,0});

        while(!dq.isEmpty()){
            int[] cur = dq.pollFirst();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            if(dists[x][y] < count) continue;

            if(x == N-1 && y == M-1) return dists[x][y];

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                int cost = map[nx][ny];
                int newCost = dists[x][y] + cost;

                if(dists[nx][ny] > newCost){
                    dists[nx][ny] = newCost;

                    if(cost == 0){
                        dq.addFirst(new int[]{nx,ny,newCost});
                    }else{
                        dq.addLast(new int[]{nx,ny,newCost});
                    }

                }

            }

        }

        return dists[N-1][M-1];
    }

}
