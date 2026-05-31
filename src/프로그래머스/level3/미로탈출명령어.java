package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
시간 초과
bfs로는 풀 수 없음
 */

public class 미로탈출명령어 {

    static int[][] map;
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    static char[] direc = {'d','l','r','u'};
    static List<String> resultList;
    static int[][] dist;
    static int n1, m1;

    static class Node implements Comparable<Node>{
        int x,y,count;
        String dir;

        public Node(int x, int y, int count, String dir){
            this.x = x;
            this.y = y;
            this.count = count;
            this.dir = dir;
        }

        public int compareTo(Node other){
            return this.dir.compareTo(other.dir);
        }

    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k){
        map = new int[n][m];
        resultList = new ArrayList<>();
        dist = new int[n][m];
        n1 = n;
        m1 = m;

        String answer = bfs(x-1,y-1,r-1,c-1,k);

        return answer;

    }

    static String bfs(int startX, int startY, int endX, int endY, int k){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startX, startY, 0, ""));
        //dist[startX][startY] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int count = cur.count;
            String dir = cur.dir;

            if(count > k) continue;
            if(x == endX && y == endY && count == k) return dir;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                char d = direc[i];

                if(nx < 0 || ny < 0 || nx >= n1 || ny >= m1) continue;

                int remain = k - (count+1);
                int manhatten = Math.abs(nx - endX) + Math.abs(ny - endY);

                if(manhatten > remain) continue;
                if((remain - manhatten) % 2 != 0) continue;
                q.offer(new Node(nx,ny,count+1,dir+d));

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
