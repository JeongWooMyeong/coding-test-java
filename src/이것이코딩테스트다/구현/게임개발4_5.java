package 이것이코딩테스트다.구현;

import java.util.*;
import java.io.*;

public class 게임개발4_5 {
    static int n,m;
    static int x,y,direction;
    static int[][] map;
    static boolean[][] visited;
    //(x,y) 기준 -> 북 (x-1,y) 동 (x, y+1), 남 (x+1, y), 서(x, y-1)
    static int[] dx = {-1, 0 , 1, 0};
    static int[] dy = {0, 1, 0 ,-1};

    static void turn_left(){
        direction--;
        if(direction == -1) direction = 3;
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        direction = sc.nextInt();
        //방문 확인
        visited = new boolean[n][m];
        visited[x][y] = true;
        //nxm 에서 입력한 숫자 입력 (대륙, 바다)
        map = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j] = sc.nextInt();
            }
        }

        int turntime = 0;
        int cnt = 1;
        while(true){
            turn_left();
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if(!visited[nx][ny] && map[nx][ny] == 0){
                //이거 빼먹음
                visited[nx][ny] = true;
                x = nx;
                y = ny;
                turntime = 0;
                cnt++;
                continue;
            }else{
                turntime++;
            }

            if(turntime == 4){
                nx = x - dx[direction];
                ny = y - dy[direction];

                if(map[nx][ny] == 0){
                    x = nx;
                    y = ny;
                }else{
                    break;
                }
                //이것도 빼먹음
                turntime = 0;
            }

        }

        System.out.println(cnt);

    }



}
