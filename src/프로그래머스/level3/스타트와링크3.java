package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 스타트와링크3 {

    static int N,M;
    static boolean[] visited;
    static int[][] board;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = N / 2;
        answer = Integer.MAX_VALUE;

        visited = new boolean[N];
        board = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(answer);

    }

    static void dfs(int idx, int count){
        if(count == M){
            answer = Math.min(answer, calculate());
            return;
        }


        for(int i=idx;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i+1, count+1);
                visited[i] = false;
            }
        }
    }

    static int calculate(){
        int startSum = 0;
        int linkSum = 0;

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(visited[i] && visited[j]){
                    linkSum += board[i][j] + board[j][i];
                }

                if(!visited[i] && !visited[j]){
                    startSum += board[i][j] + board[j][i];
                }
            }
        }


        return Math.abs(linkSum - startSum);
    }

}
