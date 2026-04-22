package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class NQUEEN6 {
    static int[] chess;
    static int N;
    static int count = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        chess = new int[N];

        nqueen(0);

        System.out.println(count);

    }

    static void nqueen(int depth){
        if(depth == N){
            count++;
            return;
        }

        for(int i=0;i<N;i++){
            //row에 넣음
            chess[depth] = i;
            if(possible(depth)){
                nqueen(depth + 1);
            }
        }
    }

    static boolean possible(int row){
        for(int i=0;i<row;i++){
            if(chess[i] == chess[row]) return false;

            if(Math.abs(row-i) == Math.abs(chess[row] - chess[i])) return false;
        }

        return true;
    }

}
