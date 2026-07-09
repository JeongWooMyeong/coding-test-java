package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 경주로건설10 {

    static int[][][] d;
    //static boolean[][] visited;
    static int n,m;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int INF = (int) 1e9;

    static class Edge implements Comparable<Edge>{
        int x;
        int y;
        int cost;
        int dir;

        public Edge(int x, int y, int cost, int dir){
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }

        public int compareTo(Edge other){
            return this.cost - other.cost;
        }

    }

    public static int solution(int[][] board){
        int answer = Integer.MAX_VALUE;
        n = board.length;
        m = board[0].length;

        dijkstra(0,0,board);

        for(int i=0;i<4;i++){
            answer = Math.min(answer, d[n-1][m-1][i]);
        }

        return answer;
    }

    static void dijkstra(int sx, int sy, int[][] board){
        PriorityQueue<Edge> q = new PriorityQueue<>();
        //visited = new boolean[n][m];
        d = new int[n][m][4];
        for(int[][] d1 : d){
            for(int[] d2 : d1){
                Arrays.fill(d2, INF);
            }
        }
        q.offer(new Edge(sx,sy,0,-1));

        while(!q.isEmpty()){
            Edge cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int cost = cur.cost;
            int dir = cur.dir;

            if(dir != -1 && d[x][y][dir] < cost) continue;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(board[nx][ny] == 1) continue;

                int ncost =  cost + (dir == -1 || dir == i ? 100 : 600);

                if(d[nx][ny][i] > ncost){
                    d[nx][ny][i] = ncost;
                    q.offer(new Edge(nx,ny,ncost,i));
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
