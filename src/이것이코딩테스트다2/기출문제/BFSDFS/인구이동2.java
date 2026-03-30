package 이것이코딩테스트다2.기출문제.BFSDFS;

import java.util.*;
import java.io.*;

public class 인구이동2 {
    static int N,L,R;
    static int[][] map;
    static List<Point> union;
    static boolean[][] visited;
    static int days=0;

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

    public static void main(String[] args) throws Exception{
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
        //인구 이동이 없을때까지 진행
        while(true){
            visited = new boolean[N][N];
            boolean move = false;

            //map for문 돌면서 union 찾기
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    //중복 방지 위해 방문하지 않은 경우만
                    if(!visited[i][j]) {
                        List<Point> union = bfs(i, j);
                        //만약 유니온 크기가 1보다 크다면 인구 이동 진행
                        if(union.size() > 1){
                            //인구이동 발생
                            move = true;
                            //인구이동 인구 갱신
                            movePeople(union);
                        }
                    }
                }
            }

            //만약 인구이동이 발생하지 않으면 나옴
            if(!move) break;
            //그렇지 않다면 계속 일수 증가하면서 인구 이동 확인
            days++;


        }

        System.out.print(days);

    }

    //bfs 돌면서 연합 찾기
    static List<Point> bfs(int a, int b){
        Queue<Point> q = new ArrayDeque<>();
        List<Point> union = new ArrayList<>();  //담을 연합 리스트
        q.offer(new Point(a, b));
        visited[a][b] = true;
        union.add(new Point(a,b));

        while(!q.isEmpty()){
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                int diff = Math.abs(map[x][y] - map[nx][ny]);
                if(diff >= L && diff <= R && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                    union.add(new Point(nx, ny));
                }

            }


        }
        return union;

    }
    //연합 리스트 인구 재갱신
    static void movePeople(List<Point> union){
        int sum = 0;
        for(Point pt : union){
            sum += map[pt.x][pt.y];
        }
        int avg = sum / union.size();

        for(Point pt : union){
            map[pt.x][pt.y] = avg;
        }
    }


}
