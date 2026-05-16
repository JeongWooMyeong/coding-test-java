package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 경주로건설3 {

    static int INF = (int) 1e9;
    static int[][][] dist;
    static int n,m;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static class Car implements Comparable<Car>{
        int x,y,cost,dir;

        public Car(int x, int y, int cost, int dir){
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }

        public int compareTo(Car other){
            return this.cost - other.cost;
        }

    }

    public static int solution(int[][] board){
        int answer = Integer.MAX_VALUE;
        n = board.length;
        m = n;

        dist = new int[n][m][4];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dist[i][j], INF);
            }
        }

        dijkstra(0,0, board);

        for(int i=0;i<4;i++) {
            answer = Math.min(answer, dist[n - 1][m - 1][i]);
        }


        return answer;
    }

    static void dijkstra(int startX, int startY, int[][] board){
        PriorityQueue<Car> pq = new PriorityQueue<>();
        pq.offer(new Car(startX,startY,0,-1));
        //거리 초기화
        for(int i=0;i<4;i++){
            dist[startX][startY][i] = 0;
        }

        while(!pq.isEmpty()){
            Car cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int cost = cur.cost;
            int dir = cur.dir;
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(board[nx][ny] == 1) continue;
                //조심 꺾을때 꺽는 비용 및 직선비용 더해야해서 600임
                int newcost = cost + (dir == -1 || dir == i ? 100 : 600);
                if(dist[nx][ny][i] > newcost){
                    dist[nx][ny][i] = newcost;
                    pq.offer(new Car(nx,ny,newcost,i));
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
