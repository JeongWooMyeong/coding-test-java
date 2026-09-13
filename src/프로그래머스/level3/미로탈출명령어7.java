package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 미로탈출명령어7 {

    static int n1, m1;
    static int[][] map;
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    static char[] direc = {'d','l','r','u'};
    static class Edge{
        int x,y;
        String dir;
        int count;

        public Edge(int x, int y, String dir, int count){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count;
        }

    }
    static String answer;

    public static String solution(int n, int m, int x, int y, int r, int c ,int k){
        map = new int[n][m];
        n1 = n;
        m1 = m;

        x--;
        y--;
        r--;
        c--;

        answer = bfs(x,y,r,c,k);

        return answer;
    }

    static String bfs(int sx, int sy, int ex, int ey, int k){
        Queue<Edge> q = new LinkedList<>();
        q.offer(new Edge(sx,sy,"",0));

        while(!q.isEmpty()){
            Edge cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            String dir = cur.dir;
            int count = cur.count;

            if(count > k) break;
            if(x == ex && y == ey && k == count) return dir;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n1 || ny >= m1) continue;

                q.offer(new Edge(nx,ny,dir + direc[i],count+1));


            }

        }

        return "impossible";
    }

    public static void main(String[] args) throws Exception{
        int n = 3;
        int m = 4;
        int x = 2;
        int y = 3;
        int r = 3;
        int c = 1;
        int k = 5;
        System.out.println(solution(n,m,x,y,r,c,k));
    }

}
