package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 스도쿠2 {

    static List<int[]> emptyList;
    static int[][] board;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[9][9];
        emptyList = new ArrayList<>();
        sb = new StringBuilder();

        for(int i=0;i<9;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0) emptyList.add(new int[]{i,j});
            }
        }

        dfs(0);

    }

    static void dfs(int idx){
        if(idx == emptyList.size()){
            printBoard();
            System.exit(0);
        }

        int[] cur = emptyList.get(idx);
        int x = cur[0];
        int y = cur[1];

        for(int i=1;i<=9;i++){
            if(check(x,y,i)){
                board[x][y] = i;
                dfs(idx+1);
                board[x][y] = 0;
            }
        }
    }

    static boolean check(int x, int y, int num){
        //행검사
        for(int c=0;c<9;c++){
            if(board[x][c] == num) return false;
        }

        //열검사
        for(int r=0;r<9;r++){
            if(board[r][y] == num) return false;
        }

        int startX = (x/3) * 3;
        int startY = (y/3) * 3;

        for(int i=startX;i<startX+3;i++){
            for(int j=startY;j<startY+3;j++){
                if(board[i][j] == num) return false;
            }
        }

        return true;
    }

    static void printBoard(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
