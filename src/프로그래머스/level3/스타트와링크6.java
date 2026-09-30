package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 스타트와링크6 {

    static int N;
    static int[][] board;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        answer = Integer.MAX_VALUE;

        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int start, int count){
        if(count == N/2){
            answer = Math.min(answer, getDiff());
            return;
        }

        for(int i=start;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i+1, count+1);
                visited[i] = false;
            }
        }

    }

    static int getDiff(){
        int linkScore = 0;
        int startScore = 0;

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(visited[i] && visited[j]){
                    linkScore += board[i][j] + board[j][i];
                }

                if(!visited[i] && !visited[j]){
                    startScore += board[i][j] + board[j][i];
                }
            }
        }


        return Math.abs(linkScore - startScore);

    }

}
