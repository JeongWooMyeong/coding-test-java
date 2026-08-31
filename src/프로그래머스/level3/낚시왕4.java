package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 낚시왕4 {

    static int R,C,M;
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
    static int answer;
    static int[] dx = {0,-1,1,0,0};
    static int[] dy = {0,0,0,1,-1};

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
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            board[r][c] = new Shark(r,c,s,d,z);
        }

        for(int c=0;c<C;c++){
            catchShark(c);

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
                    Shark shark = board[r][c];

                    int nr = shark.r;
                    int nc = shark.c;
                    int s = shark.s;
                    int dir = shark.d;
                    int z = shark.z;

                    if(dir == 1 || dir == 2){
                        s %= 2 * (R-1);
                    }else{
                        s %= 2 * (C-1);
                    }

                    for(int i=0;i<s;i++){
                        nr += dx[dir];
                        nc += dy[dir];

                        if(nr < 0 || nc < 0 || nr >= R || nc >= C){
                            nr -= dx[dir];
                            nc -= dy[dir];
                            dir = reverse(dir);
                            nr += dx[dir];
                            nc += dy[dir];
                        }

                    }

                    shark.r = nr;
                    shark.c = nc;
                    shark.d = dir;

                    if(nextMap[nr][nc] == null || nextMap[nr][nc].z < shark.z){
                        nextMap[nr][nc] = shark;
                    }

                }
            }
        }

        board = nextMap;
    }

    static int reverse(int dir){
        if(dir == 1) return 2;
        else if(dir == 2) return 1;
        else if(dir == 3) return 4;

        return 3;
    }

}
