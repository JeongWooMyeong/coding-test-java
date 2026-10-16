package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 낚시왕6 {

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
    static int[] dx = {0,-1,1,0,0};
    static int[] dy = {0,0,0,1,-1};
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sharks = new shark[R+1][C+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            sharks[r][c] = new shark(r,c,s,d,z);

        }

        answer = 0;

        for(int c=1;c<=C;c++){
            catchShark(c);

            moveShark();
        }

        System.out.println(answer);

    }

    static void catchShark(int col){
        for(int r=1;r<=R;r++){
            if(sharks[r][col] != null){
                answer += sharks[r][col].z;
                sharks[r][col] = null;
                break;
            }
        }
    }

    static void moveShark(){
        shark[][] nextMap = new shark[R+1][C+1];

        for(int r=1;r<=R;r++){
            for(int c=1;c<=C;c++){
                if(sharks[r][c] != null){
                    shark cur = sharks[r][c];

                    int r1 = cur.r;
                    int c1 = cur.c;
                    int s = cur.s;
                    int d = cur.d;
                    int z = cur.z;
                    //이거 속도 갯수인데 뭐였지
                    if(d == 1 || d == 2) {
                        s %= 2 * (R-1);
                    }else{
                        s %= 2 * (C-1);
                    }

                    for(int k=0;k<s;k++){
                        r1 += dx[d];
                        c1 += dy[d];

                        if(r1 < 1 || c1 < 1 || r1 > R || c1 > C){
                            r1 -= dx[d];
                            c1 -= dy[d];

                            d = reverse(d);

                            r1 += dx[d];
                            c1 += dy[d];

                        }

                    }

                    cur.r = r1;
                    cur.c = c1;
                    cur.d = d;

                    if(nextMap[r1][c1] == null || nextMap[r1][c1].z <= cur.z){
                        nextMap[r1][c1] = cur;
                    }

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
