package 백준.골드.level5;

import java.util.*;

public class 로봇청소기2 {
    static int n,m;
    static int[][] room;
    static int cleaned = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        room = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                room[i][j] = sc.nextInt();
            }
        }

        dfs(r, c, d);
        System.out.println(cleaned);
    }

    static void dfs(int x, int y, int dir){
        //1. 현재 칸 청소
        if(room[x][y] == 0){
            room[x][y] = -1;
            cleaned++;
        }

        //2. 주변 4칸 탐색
        for(int i=0;i<4;i++){
            dir = (dir + 3) % 4;    //반시계 회전
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m && room[nx][ny] == 0){
                dfs(nx, ny, dir);
                return;
            }
        }

        //3. 후진
        int backDir = (dir + 2) % 4;
        int bx = x + dx[backDir];
        int by = y + dy[backDir];
        if(bx >= 0 && by >= 0 && bx < n && by < m && room[bx][by] != 1){
            dfs(bx, by, dir);   //후진해서 재귀
        }
        //후진 불가능하면 종료
    }

}
