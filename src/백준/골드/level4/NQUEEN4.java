package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class NQUEEN4 {
    static int N;
    static boolean[] col;   //열 확인
    static boolean[] diag1; //오른쪽 대각선
    static boolean[] diag2; //왼쪽 대각선
    static int count = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        col = new boolean[N];
        diag1 = new boolean[2*N];   //row+col
        diag2 = new boolean[2*N];   //row-col+N (음수 방지)

        dfs(0);

        System.out.println(count);

    }

    static void dfs(int row){
        if(row == N){
            count++;
            return;
        }

        for(int c=0;c<N;c++){
            if(!col[c] && !diag1[row+c] && !diag2[row-c+N]){
                col[c] = diag1[row+c] = diag2[row-c+N] = true;
                dfs(row+1);
                col[c] = diag1[row+c] = diag2[row-c+N] = false;
            }
        }

    }

}
