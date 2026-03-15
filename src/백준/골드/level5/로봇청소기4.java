package 백준.골드.level5;

import java.util.*;
import java.io.*;

/*
dfs 방식
 */

public class 로봇청소기4 {
    static int n, m;
    static int[][] arr;
    static int cleaned = 0; //청소 수

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(r, c, d);

        System.out.print(cleaned);


    }

    public static void dfs(int x, int y, int dist){
        if(arr[x][y] == 0){
            arr[x][y] = -1;
            cleaned++;

        }

        //4칸 탐색
        for(int i=0;i<4;i++){
            //반시계 방향 회전
            dist = (dist + 3) % 4;
            int nx = x + dx[dist];
            int ny = y + dy[dist];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 0){
                dfs(nx, ny, dist);
                return;
            }

        }

        //후진
        int backDir = (dist + 2) % 4;
        int bx = x + dx[backDir];
        int by = y + dy[backDir];

        if(bx >= 0 && by >= 0 && bx < n && by < m && arr[bx][by] != 1){
            dfs(bx, by, dist);
        }


    }


}
