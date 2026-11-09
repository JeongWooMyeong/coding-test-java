package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 미세먼지안녕6 {

    static int R,C,T;
    static int[][] board;
    static int upAir;
    static int downAir;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

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
            seperate();

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

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(board[i][j] > 0) {
                    int count = 0;

                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];

                        if (ni < 0 || nj < 0 || ni >= R || nj >= C) continue;
                        if (board[ni][nj] == -1) continue;

                        temp[ni][nj] += board[i][j] / 5;
                        count++;

                    }

                    temp[i][j] += board[i][j] - (board[i][j]/5) * count;
                }
            }
        }

        temp[upAir][0] = -1;
        temp[downAir][0] = -1;

        board = temp;

    }

    static void move(){
        for(int i=upAir-1;i>0;i--) board[i][0] = board[i-1][0];
        for(int j=0;j<C-1;j++) board[0][j] = board[0][j+1];
        for(int i=0;i<upAir;i++) board[i][C-1] = board[i+1][C-1];
        for(int j=C-1;j>0;j--) board[upAir][j] = board[upAir][j-1];
        board[upAir][1] = 0;

        for(int i=downAir+1;i<R-1;i++) board[i][0] = board[i+1][0];
        for(int j=0;j<C-1;j++) board[R-1][j] = board[R-1][j+1];
        for(int i=R-1;i>downAir;i--) board[i][C-1] = board[i-1][C-1];
        for(int j=C-1;j>0;j--) board[downAir][j] = board[downAir][j-1];
        board[downAir][1] = 0;
    }

}
