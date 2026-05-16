package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
난 생각을 그냥 bfs 해도 되지 않을까 했는데
가중치가 달라서 다익스트라로 푸는게 좋을듯..
 */

public class 경주로건설2 {
    static int n,m;
    static int answer;
    //static boolean[][] visited;
    //dir까지 포함해서 3차원으로 하는게 좋음
    static int[][][] dist;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
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
        answer = Integer.MAX_VALUE;
        dist = new int[n][m][4];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dist[i][j], INF);
            }
        }


        bfs(0,0,n-1,m-1,board);

        return answer;

    }

    static void bfs(int startX, int startY, int endX, int endY, int[][] board){
        Queue<Car> q = new LinkedList<>();
        q.offer(new Car(startX, startY, -1, 0));
        //visited[startX][startY] = true;

        while(!q.isEmpty()){
            Car cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            int cost = cur.cost;
            if(x == endX && y == endY) answer = Math.min(answer, cost);

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                //if(visited[nx][ny]) continue;
                if(board[nx][ny] == 1) continue;

                int newcost = (dir == i || dir == -1) ? cost + 100 : cost + 600;

                if(dist[nx][ny][i] > newcost){
                    dist[nx][ny][i] = newcost;
                    q.offer(new Car(nx,ny,i,newcost));
                }

            }

        }

        //answer = Math.min(Math.min(dist[endX][endY][0], dist[endX][endY][1]),Math.min(dist[endX][endY][2], dist[endX][endY][3]));

    }

    public static void main(String[] args) throws Exception{
        //int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
        int[][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
        System.out.println(solution(board));
    }

}
