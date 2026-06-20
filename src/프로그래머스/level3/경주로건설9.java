package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 경주로건설9 {

    static int[][][] d;
    static int INF = (int) 1e9;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;

    static class Car implements Comparable<Car>{
        int x,y,dir,cost;

        public Car(int x, int y, int dir, int cost){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }

        public int compareTo(Car other){
            return this.cost - other.cost;
        }

    }

    public static int solution(int[][] board){
        int answer = Integer.MAX_VALUE;
        n = board.length;
        m = board[0].length;

        d = new int[n][m][4];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(d[i][j], INF);
            }
        }

        dijkstra(0,0, board);

        for(int i=0;i<4;i++){
            answer = Math.min(answer, d[n-1][m-1][i]);
        }

        return answer;
    }

    static void dijkstra(int sx, int sy, int[][] board){
        PriorityQueue<Car> pq = new PriorityQueue<>();
        pq.offer(new Car(sx,sy,-1,0));

        while(!pq.isEmpty()){
            Car cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            int cost = cur.cost;

            if(dir != -1 && d[x][y][dir] < cost) continue;

            for(int i=0;i<4;i++){
                int nx = x+ dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(board[nx][ny] == 1) continue;
                int newCost = cost + ((dir == -1 || dir == i) ? 100 : 600);

                if(d[nx][ny][i] > newCost){
                    d[nx][ny][i] = newCost;
                    pq.offer(new Car(nx,ny,i,newCost));
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
