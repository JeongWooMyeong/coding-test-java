package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 로봇청소기6 {
    static int N, M;
    static int[][] map;
    static int cleaned = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0,1,0,-1};


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //재귀 사용
        dfs(r,c,d);

        System.out.println(cleaned);


    }

    static void dfs(int r, int c, int d){
        if(map[r][c] == 0){
            map[r][c] = 2;
            cleaned++;
        }

        //4가지 방향 확인
        for(int i=0;i<4;i++){
            d = (d + 3) % 4;
            int nx = r + dx[d];
            int ny = c + dy[d];

            if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0){
                dfs(nx, ny, d);
                return;
            }

        }

        int backdir = (d + 2) % 4;
        int nx = r + dx[backdir];
        int ny = c + dy[backdir];

        if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != 1){
            dfs(nx, ny, d);
        }else{
            return;
        }


    }

}
