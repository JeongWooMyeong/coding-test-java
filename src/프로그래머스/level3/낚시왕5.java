package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 낚시왕5 {

    static int R,C,M;
    static Shark[][] map;
    static int answer;
    static class Shark{
        int r,c,s,d,z;

        public Shark(int r, int c, int s, int d, int z){
            this.r = r;
            this.c = c;
            this.d = d;
            this.s = s;
            this.z = z;
        }

    }
    static int[] dx = {0,-1,1,0,0};
    static int[] dy = {0,0,0,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R][C];
        answer = 0;


        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[r-1][c-1] = new Shark(r-1,c-1,s,d,z);
        }

        for(int c=0;c<C;c++){
            catchShark(c);

            move();
        }

        System.out.println(answer);

    }

    static void catchShark(int col){
        for(int r=0;r<R;r++){
            if(map[r][col] != null){
                answer += map[r][col].z;
                map[r][col] = null;
                break;
            }
        }
    }

    static void move(){
        Shark[][] nextMap = new Shark[R][C];

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j] != null) {
                    Shark cur = map[i][j];

                    int nr = cur.r;
                    int nc = cur.c;
                    int s = cur.s;
                    int d = cur.d;
                    int z = cur.z;

                    if(d == 1 || d == 2){
                        s %= 2 * (R-1);
                    }else{
                        s %= 2 * (C-1);
                    }

                    for(int k=0;k<s;k++){
                        nr += dx[d];
                        nc += dy[d];

                        if(nr < 0 || nc < 0 || nr >= R || nc >= C){
                            nr -= dx[d];
                            nc -= dy[d];

                            d = reverse(d);

                            nr += dx[d];
                            nc += dy[d];

                        }

                    }

                    cur.r = nr;
                    cur.c = nc;
                    cur.d = d;

                    if(nextMap[nr][nc] == null || nextMap[nr][nc].z <= cur.z){
                        nextMap[nr][nc] = cur;
                    }

                }
            }
        }

        map = nextMap;

    }

    static int reverse(int d){
        if(d == 1) return 2;
        if(d == 2) return 1;
        if(d == 3) return 4;
        return 3;
    }

}
