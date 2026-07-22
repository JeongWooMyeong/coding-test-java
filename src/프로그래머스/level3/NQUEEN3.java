package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class NQUEEN3 {

    static int N;
    static int answer;
    static boolean[] diag1;
    static boolean[] diag2;
    static boolean[] col;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        answer = 0;
        col = new boolean[N];
        diag1 = new boolean[2*N-1];
        diag2 = new boolean[2*N-1];

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
