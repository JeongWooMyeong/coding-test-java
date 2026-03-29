package 이것이코딩테스트다2.기출문제.BFSDFS;

import java.util.*;
import java.io.*;

public class 연구소 {
    static int N, M;
    static int[][] map;
    static ArrayList<Point> virus = new ArrayList<>();
    static ArrayList<Point> empty = new ArrayList<>();
    static int result = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

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
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            //map 정보 입력 virus 및 빈칸 list 채우기
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) virus.add(new Point(i,j));
                if(map[i][j] == 0) empty.add(new Point(i,j));
            }

        }
        //벽 3개 세우기
        dfs(0,0);

        //영역크기 최댓값
        System.out.print(result);

    }

    static void dfs(int idx, int count){
        //종료조건
        if(count == 3){
            //벽 세개 세웠으면 전염 시작
            simulate();
            return;
        }

        if(idx == empty.size()) return;

        Point pt = empty.get(idx);
        //벽 세우는 경우
        map[pt.x][pt.y] = 1;
        dfs(idx + 1, count + 1);
        map[pt.x][pt.y] = 0;    //되돌리기

        //벽 안세우는 경우
        dfs(idx + 1, count);

    }

    static void simulate(){
        Queue<Point> q = new LinkedList<>();
        //바이러스는 동시다발적으로 퍼지므로 바이러스인거 다 넣어주기
        int[][] temp = new int[N][M];
        for(int i=0;i<N;i++) temp[i] = map[i].clone();

        for(Point p : virus) q.offer(p);

        while(!q.isEmpty()){
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            //4가지 방향에 대해서 진행
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(temp[nx][ny] == 0){
                    temp[nx][ny] = 2;
                    q.offer(new Point(nx, ny));
                }

            }
        }

        CalculateEmpty(temp);

    }

    static void CalculateEmpty(int[][] temp){
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(temp[i][j] == 0) count++;
            }
        }

        result = Math.max(result, count);
    }

}
