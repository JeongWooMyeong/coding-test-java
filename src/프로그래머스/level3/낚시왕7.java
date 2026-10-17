package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 낚시왕7 {

    static int R,C,M;
    static class shark{
        int r,c,s,d,z;

        public shark(int r, int c, int s, int d, int z){
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

    }
    static shark[][] sharks;
    static int answer;
    static int[] dx = {0,-1,1,0,0};
    static int[] dy = {0,0,0,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sharks = new shark[R+1][C+1];
        answer = 0;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            sharks[r][c] = new shark(r,c,s,d,z);
        }

        for(int col=1;col<=C;col++){
            catchShark(col);

            moveShark();
        }

        System.out.println(answer);
    }

    static void catchShark(int col){
        for(int row=1;row<=R;row++){
            if(sharks[row][col] != null){
                answer += sharks[row][col].z;
                sharks[row][col] = null;
                break;
            }
        }
    }

    static void moveShark(){
        shark[][] nextMap = new shark[R+1][C+1];

        for(int r=1;r<=R;r++){
            for(int c=1;c<=C;c++) {
                if (sharks[r][c] != null) {
                    shark cur = sharks[r][c];

                    int nr = cur.r;
                    int nc = cur.c;
                    int s = cur.s;
                    int d = cur.d;
                    int z = cur.z;

                    if (d == 1 || d == 2) {
                        if(R > 1) s %= 2 * (R - 1);
                        else s = 0;
                    } else {
                        if(C > 1) s %= 2 * (C - 1);
                        else s = 0;
                    }

                    for (int k = 0; k < s; k++) {
                        nr += dx[d];
                        nc += dy[d];

                        if (nr < 1 || nc < 1 || nr > R || nc > C) {
                            nr -= dx[d];
                            nc -= dy[d];

                            d = reverse(d);

                            nr += dx[d];
                            nc += dy[d];

                        }

                    }

                    if (nextMap[nr][nc] == null || nextMap[nr][nc].z < cur.z) {
                        nextMap[nr][nc] = cur;
                    }

                    cur.r = nr;
                    cur.c = nc;
                    cur.d = d;

                }
            }
        }

        sharks = nextMap;

    }

    static int reverse(int dir){
        if(dir == 1) return 2;
        else if(dir == 2) return 1;
        else if(dir == 3) return 4;

        return 3;
    }

}
