package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 경주로건설13 {

    static int n,m;
    static int[][][] d;
    static int INF = (int) 1e9;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static class Edge implements Comparable<Edge>{
        int x,y;
        int cost;
        int dir;

        public Edge(int x, int y , int cost, int dir){
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }

        public int compareTo(Edge other){
            return Integer.compare(this.cost, other.cost);
        }

    }

    public static int solution(int[][] board){
        n = board.length;
        m = board[0].length;

        d = new int[n][n][4];

        for(int[][] d1 : d){
            for(int[] d2 : d1){
                Arrays.fill(d2, INF);
            }
        }

        dijkstra(0,0, board);

        int answer = Integer.MAX_VALUE;

        for(int i=0;i<4;i++){
            answer = Math.min(answer, d[n-1][m-1][i]);
        }

        return answer;

    }

    static void dijkstra(int sx, int sy, int[][] board){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(sx,sy,0,-1));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            int cost = cur.cost;

            if(dir != -1 && d[x][y][dir] < cost){
                continue;
            }

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(board[nx][ny] == 1) continue;

                int nextCost;

                if(dir == -1 || (dir == i)){
                    nextCost = cost + 100;
                }else{
                    nextCost = cost + 600;
                }

                if(d[nx][ny][i] > nextCost){
                    d[nx][ny][i] = nextCost;
                    pq.offer(new Edge(nx,ny,nextCost,i));
                }


            }

        }
    }

    public static void main(String[] args) throws Exception{
        //int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
        int[][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
        System.out.println(solution(board));
    }

}
