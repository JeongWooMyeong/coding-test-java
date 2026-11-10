package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 미세먼지안녕7 {

    static int R,C,T;
    static int[][] map;
    static int upAir;
    static int downAir;
    static int answer;
    static int[] dr = {-1,0,1,0};
    static int[] dc  = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        upAir = -1;
        downAir = -1;
        answer = 0;

        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    if(upAir == -1) upAir = i;
                    else if(downAir == -1) downAir = i;
                }
            }
        }

        while(T-- > 0){
            seperate();

            move();
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j] > 0){
                    answer += map[i][j];
                }
            }
        }

        System.out.println(answer);

    }

    static void seperate(){
        int[][] temp = new int[R][C];

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j] > 0){
                    int count = 0;
                    for(int d=0;d<4;d++){
                        int ni = i + dr[d];
                        int nj = j + dc[d];

                        if(ni < 0 || nj < 0 || ni >= R || nj >= C) continue;
                        if(map[ni][nj] == -1) continue;

                        temp[ni][nj] += map[i][j] / 5;
                        count++;
                    }

                    temp[i][j] += map[i][j] - (map[i][j] / 5) * count;
                }
            }
        }

        temp[upAir][0] = -1;
        temp[downAir][0] = -1;

        map = temp;

    }

    static void move(){
        for(int i=upAir-1;i>0;i--) map[i][0] = map[i-1][0];
        for(int j=0;j<C-1;j++) map[0][j] = map[0][j+1];
        for(int i=0;i<upAir;i++) map[i][C-1] = map[i+1][C-1];
        for(int j=C-1;j>0;j--) map[upAir][j] = map[upAir][j-1];
        map[upAir][1] = 0;

        for(int i=downAir+1;i<R-1;i++) map[i][0] = map[i+1][0];
        for(int j=0;j<C-1;j++) map[R-1][j] = map[R-1][j+1];
        for(int i=R-1;i>downAir;i--) map[i][C-1] = map[i-1][C-1];
        for(int j=C-1;j>0;j--) map[downAir][j] = map[downAir][j-1];
        map[downAir][1] = 0;
    }

}
