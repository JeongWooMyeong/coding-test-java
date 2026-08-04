package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 스도쿠 {

    static int[][] board;
    static List<int[]> empty;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[9][9];
        empty = new ArrayList<>();

        for(int i=0;i<9;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0) empty.add(new int[]{i,j});
            }
        }


        dfs(0);

    }

    static void dfs(int idx){
        if(idx == empty.size()){
            PrintBoard();
            System.exit(0); // 답은 유일하므로 바로 종료
        }

        int[] e = empty.get(idx);
        int r = e[0];
        int c = e[1];

        for(int num=1;num<=9;num++){
            if(isValid(r,c,num)){
                board[r][c] = num;
                dfs(idx+1);
                board[r][c] = 0;
            }
        }

    }

    static boolean isValid(int r, int c, int num){
        int r1 = (r / 3) * 3;
        int c1 = (c / 3) * 3;

        //열
        for(int j=0;j<9;j++) if(j != c && board[r][j] == num) return false;
        for(int i=0;i<9;i++) if(i != r && board[i][c] == num) return false;

        for(int i=r1;i<r1+3;i++){
            for(int j=c1;j<c1+3;j++){
                if(i == r && j== c) continue;
                if(board[i][j] == num) return false;
            }
        }


        return true;

    }

    static void PrintBoard(){
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}
