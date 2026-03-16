package 백준.골드.level4;

import java.io.*;
import java.util.*;

public class 미세먼지안녕2 {
    static int R, C, T;
    static int[][] map;
    static int upCleaner, downCleaner;   //공기 청정기 위치

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        upCleaner = -1;

        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    if(upCleaner == -1) upCleaner = i;
                    else downCleaner = i;
                }
            }
        }

        for(int t=0;t<T;t++){
            spreadDust();
            operateCleaner();
        }

        System.out.println(countDust());

    }

    //1. 미세먼지 확산
    static void spreadDust(){
        int[][] temp = new int[R][C];

        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(map[r][c] > 0){
                    int amount = map[r][c] / 5;
                    int cnt = 0;

                    for(int d=0;d<4;d++){
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                        if(map[nr][nc] == -1) continue;

                        temp[nr][nc] += amount;
                        cnt++;
                    }

                    temp[r][c] += map[r][c] - amount * cnt;
                }
            }
        }

        //공기청정기 위치 복원
        temp[upCleaner][0] = -1;
        temp[downCleaner][0] = -1;

        map = temp;

    }

    //2. 공기 청정기 작동
    static void operateCleaner(){
        //위쪽 (반시계)
        for(int r=upCleaner-1;r>0;r--) map[r][0] = map[r-1][0];
        for(int c=0;c<C-1;c++) map[0][c] = map[0][c+1];
        for(int r=0;r<upCleaner;r++) map[r][C-1] = map[r+1][C-1];
        for(int c=C-1;c>1;c--) map[upCleaner][c] = map[upCleaner][c-1];
        map[upCleaner][1] = 0;

        //아래족 (시계)
        for(int r=downCleaner + 1; r < R-1;r++) map[r][0] = map[r+1][0];
        for(int c=0;c<C-1;c++)map[R-1][c] = map[R-1][c+1];
        for(int r=R-1;r>downCleaner;r--) map[r][C-1] = map[r-1][C-1];
        for(int c=C-1;c>1;c--) map[downCleaner][c] = map[downCleaner][c-1];
        map[downCleaner][1] = 0;
    }

    //3. 남은 먼지 합산
    static int countDust(){
        int sum = 0;
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(map[r][c] > 0) sum += map[r][c];
            }
        }
        return sum;
    }

}
