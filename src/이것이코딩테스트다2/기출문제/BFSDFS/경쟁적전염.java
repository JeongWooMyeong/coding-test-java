package 이것이코딩테스트다2.기출문제.BFSDFS;

import java.util.*;
import java.io.*;

public class 경쟁적전염 {
    static int N, K;
    static int[][] map;
    static ArrayList<Point> virusList = new ArrayList<>();
    static int S, X, Y;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int type;
        int time;

        public Point(int x, int y, int type, int time){
            this.x = x;
            this.y = y;
            this.type = type;
            this.time = time;
        }

        public int compareTo(Point other){
            return this.type - other.type;
        }



    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                //바이러스 리스트 담기
                if(map[i][j] != 0 && map[i][j] <= K){
                    virusList.add(new Point(i, j, map[i][j], 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        Collections.sort(virusList);

        bfs(0);

        System.out.print(map[X-1][Y-1]);

    }

    static void bfs(int start){
        Queue<Point> q = new ArrayDeque<>();
        for(Point pt : virusList) q.offer(new Point(pt.x, pt.y, pt.type, 0));

        while(!q.isEmpty()){
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int type = cur.type;
            int time = cur.time;

            if(time == S){
                break;
            }

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if(map[nx][ny] == 0){
                    map[nx][ny] = type;
                    q.offer(new Point(nx, ny, type, time+1));
                }

            }



        }

    }

}
