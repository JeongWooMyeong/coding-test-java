package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class NQUEEN4 {

    static int N;
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;
    static int answer;

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

    static void dfs(int rows){
        if(rows == N){
            answer++;
            return;
        }

        for(int c=0;c<N;c++){
            int dia1 = rows + c;
            int dia2 = rows - c + N - 1;

            if(col[c] || diag1[dia1] || diag2[dia2]) continue;

            col[c] = true;
            diag1[dia1] = true;
            diag2[dia2] = true;

            dfs(rows+1);

            col[c] = false;
            diag1[dia1] = false;
            diag2[dia2] = false;

        }

    }

}
