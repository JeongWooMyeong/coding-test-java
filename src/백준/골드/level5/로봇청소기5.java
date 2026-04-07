package 백준.골드.level5;

import java.util.*;
import java.io.*;

/*
잘못 짬
 */

public class 로봇청소기5 {
    static int N, M;
    static int[][] map;
    static boolean[] visited;
    static int result = 0;
    static int dir;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());   //청소기 시작 좌표
        int y = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(x,y);

        System.out.println(calculate());


    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});

        if(map[x][y] == 0){
            map[x][y] = 2;
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];

            for(int i=0;i<4;i++){
                int nx = x1 + dx[i];
                int ny = y1 + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) break;
                //빈칸이 없는 경우
                if(map[nx][ny] != 0 ){
                    int backdir = (dir+2)%4;
                    if(map[x1 + dx[backdir]][y1 + dy[backdir]] != 1){
                        q.offer(new int[]{x1+backdir, y1+backdir});
                    }else{
                        return;
                    }
                }else{
                    int rotate = (dir+3)%4;
                    if(map[x1 + dx[rotate]][y1 + dy[rotate]] == 0){
                        map[x1 + dx[rotate]][y1 + dy[rotate]] = 2;
                        q.offer(new int[]{x1 + rotate, y1 + rotate});
                    }
                }

            }



        }

    }

    static int calculate(){
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 2){
                    count++;
                }
            }
        }

        return count;
    }

}
