package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class NQUEEN2 {

    static boolean[] col;
    static boolean[] diag1; //오른쪽 대각선
    static boolean[] diag2; //왼쪽 대각선
    static int N;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        col = new boolean[N];
        diag1 = new boolean[2*N-1];
        diag2 = new boolean[2*N-1];

        answer = 0;
        dfs(0);

        System.out.println(answer);

    }

    static void dfs(int row){

        if(row == N){
            answer++;
            return;
        }

        for(int c=0;c<N;c++){
            int dia1 = row + c;
            int dia2 = row - c + N - 1;

            if(col[c] || diag1[dia1] || diag2[dia2]) continue;

            col[c] = true;
            diag1[dia1] = true;
            diag2[dia2] = true;

            dfs(row + 1);

            col[c] = false;
            diag1[dia1] = false;
            diag2[dia2] = false;


        }


    }

}
