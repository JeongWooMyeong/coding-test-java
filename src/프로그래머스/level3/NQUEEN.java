package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class NQUEEN {

    static int N;
    static boolean[] col;
    static boolean[] diag1; //오른쪽 대각선
    static boolean[] diag2; //왼쪽 대각선
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
            int d1 = (row + c);
            int d2 = (row - c + N - 1);

            if(col[c] || diag1[d1] || diag2[d2]) continue;

            col[c] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            dfs(row + 1);

            col[c] = false;
            diag1[d1] = false;
            diag2[d2] = false;

        }

    }

}
