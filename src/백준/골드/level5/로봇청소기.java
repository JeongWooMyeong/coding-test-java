package 백준.골드.level5;

import java.util.*;

public class 로봇청소기 {
    static int n, m;
    static int[][] room;
    static int r, c, d;
    static int[] dx = {-1, 0, 1, 0};    //북 동 남 서
    static int[] dy = {0 , 1, 0, -1};
    static int cleaned = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        room = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                room[i][j] = sc.nextInt();
            }
        }

        simulate();
        System.out.println(cleaned);
    }

    static void simulate(){
        while(true){
            //1. 현재 칸 청소
            if(room[r][c] == 0){
                room[r][c] = -1;    //청소 표시
                cleaned++;
            }

            boolean found = false;
            //2. 주변 4칸 탐색
            for(int i=0;i<4;i++){
                d = (d + 3) % 4;    //반시계 회전
                int nx = r + dx[d];
                int ny = c + dy[d];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && room[nx][ny] == 0){
                    r = nx; c = ny;
                    found = true;
                    break;
                }

            }

            if(found) continue;

            //3. 후진
            int backDir = (d+2) % 4;
            int bx = r + dx[backDir];
            int by = c + dy[backDir];
            if(bx < 0 || by < 0 || bx >= n || by >= m || room[bx][by] == 1){
                break;
            }else{
                r = bx; c = by;
            }

        }
    }
}
