package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 경주로건설11 {

    static int[][][] d;
    static int INF = Integer.MAX_VALUE;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;
    static int answer;

    static class Edge implements Comparable<Edge>{
        int x,y, cost, dir;

        public Edge(int x, int y, int cost, int dir){
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
        answer = Integer.MAX_VALUE;

        dijkstra(0,0, board);

        for(int i=0;i<4;i++){
            answer = Math.min(answer, d[n-1][m-1][i]);
        }

        return answer;
    }

    static void dijkstra(int sx, int sy, int[][] board){
        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(sx, sy, 0, -1));
        d = new int[n][m][4];

        for(int[][] d1 : d){
            for(int[] d2 : d1){
                Arrays.fill(d2, INF);
            }
        }

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int dist = cur.cost;
            int dir = cur.dir;

            if(dir != -1 && d[x][y][dir] < dist) continue;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(board[nx][ny] == 1) continue;

                int ncost = dist + ((dir == -1 || dir == i) ? 100 : 600);

                if(d[nx][ny][i] > ncost){
                    d[nx][ny][i] = ncost;
                    pq.offer(new Edge(nx,ny,ncost,i));
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
