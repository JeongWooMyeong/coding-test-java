package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 알고스팟 {

    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static class Edge implements Comparable<Edge>{
        int x,y;
        int count;

        public Edge(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int compareTo(Edge other){
            return Integer.compare(this.count, other.count);
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

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
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        visited[sx][sy] = true;
        pq.offer(new Edge(sx,sy,0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int count = cur.count;

            if(x == N-1 && y == M-1) return count;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;

                if(map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    pq.offer(new Edge(nx,ny,count+1));
                }else{
                    visited[nx][ny] = true;
                    pq.offer(new Edge(nx,ny,count));
                }

            }

        }

        return -1;
    }

}
