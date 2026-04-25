package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 경주로건설 {
    static int n;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int INF = (int) 1e9;

    static class Edge implements Comparable<Edge>{
        int x,y,dir,cost;

        public Edge(int x, int y, int dir, int cost){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return this.cost - other.cost;
        }

    }

    public static int solution(int[][] board){
        int answer = 0;
        n = board.length;
        int[][][] dist = new int[n][n][4];
        for(int[][] d : dist){
            for(int[] row : d){
                Arrays.fill(row, INF);
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        //4가지 방향 넣기
        for(int d=0;d<4;d++){
            dist[0][0][d] = 0;
            pq.offer(new Edge(0, 0, d, 0));
        }

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            int cost = cur.cost;
            if(x == n - 1 && y == n - 1) return cost;
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(board[nx][ny] == 1) continue;

                int nc = cost + (i == dir ? 100 : 600);
                if(dist[nx][ny][i] > nc){
                    dist[nx][ny][i] = nc;
                    pq.offer(new Edge(nx,ny,i,nc));
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(solution(board));
    }

}
