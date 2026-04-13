package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 벽부수고이동하기3 {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static class Point{
        int x;
        int y;
        int dist;
        int broken;

        public Point(int x, int y, int dist, int broken){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2]; //3번째는 벽부숨 여부

        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }


        System.out.println(bfs());

    }

    static int bfs(){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0,1,0));    //0 벽부수지 않음 1 벽 부숨
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int dist = cur.dist;
            int broken = cur.broken;

            if(x == N-1 && y == M-1) return dist;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                //빈칸 이동
                if(!visited[nx][ny][broken] && map[nx][ny] == 0){
                    visited[nx][ny][broken] = true;
                    q.offer(new Point(nx, ny, dist+1, broken));

                }

                //벽 부수기
                if(!visited[nx][ny][1] && map[nx][ny] == 1 && broken != 1){
                    visited[nx][ny][1] = true;
                    q.offer(new Point(nx, ny, dist+1, 1));
                }

            }

        }


        return -1;
    }

}
