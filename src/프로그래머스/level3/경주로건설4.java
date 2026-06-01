package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 경주로건설4 {

    static int[][][] dist;
    //static boolean[][][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int n,m;
    static int INF = (int) 1e9;

    static class Car{
        int x,y,dir,cost;

        public Car(int x, int y, int dir, int cost){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }

    }


    public static int solution(int[][] board){
        n = board.length;
        m = board[0].length;

        bfs(0,0, board);

        int answer = Integer.MAX_VALUE;

        for(int i=0;i<4;i++){
            answer = Math.min(answer, dist[n-1][m-1][i]);
        }


        return answer;
    }

    static void bfs(int startX, int startY, int[][] board){
        Queue<Car> q = new LinkedList<>();
        //visited = new boolean[n][m][4];
        dist = new int[n][m][4];
        q.offer(new Car(startX,startY,-1,0));
        //dist[startX][startY][-1] = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dist[i][j], INF);
            }
        }

        while(!q.isEmpty()){
            Car cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int cost = cur.cost;
            int dir = cur.dir;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(board[nx][ny] == 1) continue;

                int newCost = cost + (dir == -1 || dir == i ? 100 : 600);
                if(dist[nx][ny][i] > newCost){
                    dist[nx][ny][i] = newCost;
                    q.offer(new Car(nx,ny,i,newCost));
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
