package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 스도쿠3 {

    static int[][] map = new int[9][9];
    static List<int[]> empty;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        empty = new ArrayList<>();

        for(int i=0;i<9;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) empty.add(new int[]{i,j});
            }
        }

        visited = new boolean[empty.size()];

        dfs(0);

    }

    static void dfs(int count){
        if(count == empty.size()){
            printBoard();
            System.exit(0);
        }

        int[] arr = empty.get(count);
        int row = arr[0];
        int col = arr[1];

        for (int j = 1; j <= 9; j++) {
            if(isCheck(row,col,j)){
                map[row][col] = j;
                dfs(count+1);
                map[row][col] = 0;
            }
        }


    }

    static boolean isCheck(int row, int col, int value){

        for(int c=0;c<9;c++){
            if(c == col) continue;
            if(map[row][c] == value) return false;
        }

        for(int r=0;r<9;r++){
            if(r == row) continue;
            if(map[r][col] == value) return false;
        }

        int startR = row / 3 * 3;
        int startC = col / 3 * 3;

        for(int r=startR;r<startR+3;r++){
            for(int c=startC;c<startC+3;c++){
                if(r == row && c == col) continue;
                if(map[r][c] == value) return false;
            }
        }

        return true;
    }

    static void printBoard(){
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
