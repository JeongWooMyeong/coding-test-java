package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 낚시왕3 {

    static int R,C,M;
    static int answer;
    static Shark[][] board;
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
    static int[] dr = {0,-1,1,0,0};
    static int[] dc = {0,0,0,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new Shark[R][C];
        answer = 0;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            board[r-1][c-1] = new Shark(r-1,c-1,s,d,z);
        }

        for(int i=0;i<C;i++){
            catchShark(i);

            move();
        }


        System.out.println(answer);

    }

    static void catchShark(int col){
        for(int i=0;i<R;i++){
            if(board[i][col] != null){
                answer += board[i][col].z;
                board[i][col] = null;
                break;
            }
        }
    }

    static void move(){
        Shark[][] nextMap = new Shark[R][C];

        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(board[r][c] != null) {
                    Shark cur = board[r][c];
                    int nr = cur.r;
                    int nc = cur.c;
                    int s = cur.s;
                    int d = cur.d;
                    int z = cur.z;

                    if (d == 1 || d == 2) {
                        s %= 2 * (R - 1);
                    } else {
                        s %= 2 * (C - 1);
                    }

                    for (int i = 0; i < s; i++) {
                        nr += dr[d];
                        nc += dc[d];

                        if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                            nr -= dr[d];
                            nc -= dc[d];
                            d = reverse(d);
                            nr += dr[d];
                            nc += dc[d];
                        }
                    }

                    cur.r = nr;
                    cur.c = nc;
                    cur.d = d;

                    if (nextMap[nr][nc] == null || nextMap[nr][nc].z < cur.z) {
                        nextMap[nr][nc] = cur;
                    }
                }

            }
        }

        board = nextMap;

    }

    static int reverse(int dir){
        if(dir == 1) return 2;
        if(dir == 2) return 1;
        if(dir == 3) return 4;

        return 3;

    }

}
