package 이것이코딩테스트다2.기출문제.BFSDFS;

import java.util.*;
import java.io.*;

public class 인구이동 {
    static int N, L, R;
    //static List<Point> union = new ArrayList<>();
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] arg) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        //맵 정보 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
               map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //반복문 돌리면서 연합 없을때까지 반복

        int days = 0;

        while(true){
            visited = new boolean[N][N];
            boolean move = false;

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j]){
                        List<Point> union = bfs(i,j);
                        if(union.size() > 1){
                            move = true;
                            movePeople(union);
                        }
                    }
                }
            }
            //인구 이동 없다는거 while문 나감
            if(!move) break;
            days++;

        }

        System.out.println(days);
    }

    static List<Point> bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        List<Point> union = new ArrayList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        union.add(new Point(x, y));

        while(!q.isEmpty()){
            Point cur = q.poll();
            int x1 = cur.x;
            int y1 = cur.y;

            for(int i=0;i<4;i++){
                int nx = x1 + dx[i];
                int ny = y1 + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >=N) continue;

                int result = Math.abs(map[x1][y1] - map[nx][ny]);
                if(result >= L && result <= R && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                    union.add(new Point(nx, ny));
                }

            }



        }

        return union;

    }

    static void movePeople(List<Point> union){
        int sum = 0;
        for(Point pt : union){
            int x = pt.x;
            int y = pt.y;
            sum += map[x][y];
        }

        int avg =  sum / union.size();

        for(Point pt : union){
            int x = pt.x;
            int y = pt.y;
            map[x][y] = avg;
        }

    }

}
