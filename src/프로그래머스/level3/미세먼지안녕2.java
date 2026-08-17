package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 미세먼지안녕2 {

    static int R,C,T;
    static int[][] map;
    static int upAir;
    static int downAir;
    static int answer;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        answer = 0;
        map = new int[R][C];

        upAir = -1;
        downAir = -1;

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

            operate();
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
                if(map[i][j] > 0) {
                    int amount = map[i][j] / 5;
                    int count = 0;
                    int nr;
                    int nc;

                    for (int d = 0; d < 4; d++) {
                        nr = i + dr[d];
                        nc = j + dc[d];

                        if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                        if(map[nr][nc] == -1) continue;

                        temp[nr][nc] += amount;
                        count++;
                    }

                    temp[i][j] += map[i][j] - (amount * count);
                }
            }
        }

        temp[upAir][0] = -1;
        temp[downAir][0] = -1;

        map = temp;


    }

    static void operate(){
        for(int i=upAir-1;i>0;i--) map[i][0] = map[i-1][0];
        for(int i=0;i<C-1;i++) map[0][i] = map[0][i+1];
        for(int i=0;i<upAir;i++) map[i][C-1] = map[i+1][C-1];
        for(int i=C-1;i>0;i--) map[upAir][i] = map[upAir][i-1];
        map[upAir][1] = 0;

        for(int i=downAir+1;i<R-1;i++) map[i][0] = map[i+1][0];
        for(int i=0;i<C-1;i++) map[R-1][i] = map[R-1][i+1];
        for(int i=R-1;i>downAir;i--) map[i][C-1] = map[i-1][C-1];
        for(int i=C-1;i>0;i--) map[downAir][i] = map[downAir][i-1];
        map[downAir][1] = 0;

    }



}
