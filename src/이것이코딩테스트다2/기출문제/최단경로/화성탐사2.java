package 이것이코딩테스트다2.기출문제.최단경로;

import java.util.*;
import java.io.*;

public class 화성탐사2 {
    static int T;
    static int N;
    static int[][] map;
    static int[][] dist;
    static final int INF = (int) 1e9;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static StringBuilder sb = new StringBuilder();

    static class Edge implements Comparable<Edge>{
        private int x;
        private int y;
        private int cost;

        public Edge(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }

        public int getCost(){
            return this.cost;
        }

        public int compareTo(Edge other){
            return this.cost - other.cost;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF;
                }
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.offer(new Edge(0, 0, map[0][0]));
            dist[0][0] = map[0][0];

            while(!pq.isEmpty()){
                Edge cur = pq.poll();
                int x = cur.getX();
                int y = cur.getY();
                int dists = cur.getCost();
                if(dist[x][y] < dists) continue;
                for(int i=0;i<4;i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    int cost = dists + map[nx][ny];
                    if(dist[nx][ny] > cost){
                        dist[nx][ny] = cost;
                        pq.offer(new Edge(nx, ny, cost));
                    }


                }

            }


            sb.append(dist[N-1][N-1]).append("\n");

        }

        System.out.print(sb);

    }

}
