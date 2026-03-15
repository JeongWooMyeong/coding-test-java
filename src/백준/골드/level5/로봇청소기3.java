package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 로봇청소기3 {
    static int n, m;
    static int[][] arr;
    static int r, c, d;
    static int cleaned = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulate();

        System.out.println(cleaned);



    }

    public static void simulate(){

        while(true) {
            if(arr[r][c] == 0){
                arr[r][c] = -1;
                cleaned++;
            }
            boolean found = false;
            //4칸 탐색
            for (int i = 0; i < 4; i++) {
                //반시계 회전..
                d = (d+3) % 4;

                int nx = r + dx[d];
                int ny = c + dy[d];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    found = true;
                    break;
                }

            }

            if(found) continue;

            //후진
            int backDir = (d + 2) % 4;
            int bx = r + dx[backDir];
            int by = c + dy[backDir];

            if (bx < 0 || by < 0 || bx >= n || by >= m || arr[bx][by] == 1) {
                break;
            } else {
                r = bx;
                c = by;
            }
        }

    }

}
