package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 낚시왕 {

    static int R,C,M;
    static int answer;
    static Shark[][] map;
    static int[] dr = {0,-1,1,0,0};
    static int[] dc = {0,0,0,1,-1};
    static class Shark{
        int r,c,s,d,z;

        public Shark(int r, int c, int s, int d, int z){
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = 0;
        map = new Shark[R][C];

        //상어 정보 입력
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());


            map[r-1][c-1] = new Shark(r-1,c-1,s,d,z);  //상어 위치 표시
        }

        //낚시왕의 이동
        for(int c=0;c<C;c++){
            //같은 열에 있는 상어 잡기
            catchShark(c);

            //상어 이동
            move();

        }

        System.out.println(answer);
    }

    static void move(){
        Shark[][] nextMap = new Shark[R][C];

        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(map[r][c] == null) continue;
                Shark cur = map[r][c];
                int nr = cur.r;
                int nc = cur.c;
                int nd = cur.d;
                int speed = cur.s;

                if(nd == 1 || nd == 2){
                    speed %= 2 * (R-1);
                }else{
                    speed %= 2 * (C-1);
                }


                for(int k =0;k<speed;k++) {
                    nr += dr[nd];
                    nc += dc[nd];

                    if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                        nr -= dr[nd];
                        nc -= dc[nd];

                        nd = reverse(nd);

                        nr += dr[nd];
                        nc += dc[nd];

                    }
                }

                cur.d = nd;
                cur.r = nr;
                cur.c = nc;


                if(nextMap[nr][nc] == null || nextMap[nr][nc].z < cur.z){
                    nextMap[nr][nc] = cur;
                }

            }
        }

        map = nextMap;

    }

    static int reverse(int dir){
        if(dir == 1) return 2;
        else if(dir == 2) return 1;
        else if(dir == 3) return 4;
        return 3;
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

}
