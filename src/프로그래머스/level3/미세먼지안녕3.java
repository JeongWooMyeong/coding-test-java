package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 미세먼지안녕3 {

    static int R,C,T;
    static int upAir;
    static int downAir;
    static int[][] board;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        upAir = -1;
        downAir = -1;

        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == -1){
                    if(upAir == -1) upAir = i;
                    else if(downAir == -1) downAir = i;
                }
            }
        }

        while(T-- > 0){
            //확산
            seperate();
            //공기 청정기 이동
            move();
        }

        int answer = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(board[i][j] > 0){
                    answer += board[i][j];
                }
            }
        }

        System.out.println(answer);
    }

    static void seperate(){

        int[][] temp = new int[R][C];

        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(board[r][c] > 0){
                    int amount = board[r][c] / 5;
                    int count = 0;
                    int nr;
                    int nc;

                    for(int d=0;d<4;d++){
                        nr = r + dr[d];
                        nc = c + dc[d];

                        if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                        if(board[nr][nc] == -1) continue;

                        temp[nr][nc] += amount;
                        count++;

                    }

                    temp[r][c] += board[r][c] - (amount * count);

                }
            }
        }

        temp[upAir][0] = -1;
        temp[downAir][0] = -1;

        board = temp;

    }
    //공기 청정기 이동
    static void move(){
        for(int i=upAir-1;i>0;i--) board[i][0] = board[i-1][0];
        for(int i=0;i<C-1;i++) board[0][i] = board[0][i+1];
        for(int i=0;i<upAir;i++) board[i][C-1] = board[i+1][C-1];
        for(int i=C-1;i>0;i--) board[upAir][i] = board[upAir][i-1];
        board[upAir][1] = 0;

        for(int i=downAir+1;i<R-1;i++) board[i][0] = board[i+1][0];
        for(int i=0;i<C-1;i++) board[R-1][i] = board[R-1][i+1];
        for(int i=R-1;i>downAir;i--) board[i][C-1] = board[i-1][C-1];
        for(int i=C-1;i>0;i--) board[downAir][i] = board[downAir][i-1];
        board[downAir][1] = 0;
    }

}
