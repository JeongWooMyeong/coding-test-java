package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 벽부수고이동하기3 {

    static int N,M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static class Edge{
        int x,y,count;
        boolean visited;

        public Edge(int x, int y, int count, boolean visited){
            this.x = x;
            this.y = y;
            this.count = count;
            this.visited = visited;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<line.length();j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int answer = bfs(0,0);

        System.out.println(answer);
    }

    static int bfs(int sx, int sy){
        Queue<Edge> q = new LinkedList<>();
        q.offer(new Edge(sx,sy,1,false));
        visited[sx][sy][0] = true;

        while(!q.isEmpty()){
            Edge cur = q.poll();

            int x = cur.x;
            int y = cur.y;
            int count = cur.count;
            boolean visiteds = cur.visited;

            if(x == N-1 && y == M-1) return count;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                //if(visited[nx][ny][0] || visited[nx][ny][1]) continue;

                if(map[nx][ny] == 1 && !visiteds && !visited[nx][ny][1]){
                    visited[nx][ny][1] = true;
                    q.offer(new Edge(nx,ny,count+1,true));
                }

                if(map[nx][ny] == 0 && !visited[nx][ny][visiteds ? 1 : 0]){
                    visited[nx][ny][0] = true;
                    q.offer(new Edge(nx,ny, count+1, visiteds));
                }

            }

        }

        return -1;

    }

}
