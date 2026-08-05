package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 스타트와링크2 {

    static int N, M;
    static int[][] board;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = N / 2;
        answer = Integer.MAX_VALUE;

        board = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, new ArrayList<>(), new ArrayList<>());

        System.out.println(answer);
    }

    static void dfs(int idx, List<Integer> start, List<Integer> link){
        if(start.size() == M && link.size() == M){
            answer = Math.min(answer, getScore(start, link));
            return;
        }

        if(start.size() > M || link.size() > M) return;

        if(idx == N) return;

        start.add(idx);
        dfs(idx+1, start, link);
        start.remove(start.size()-1);

        link.add(idx);
        dfs(idx+1, start, link);
        link.remove(link.size()-1);


    }

    static int getScore(List<Integer> start, List<Integer> link){
        int startSum = 0;
        int linkSum = 0;

        for(int i=0;i<start.size();i++){
            for(int j=i+1;j<start.size();j++){
                int a = start.get(i);
                int b = start.get(j);

                int a1 = link.get(i);
                int b1 = link.get(j);

                startSum += board[a][b] + board[b][a];
                linkSum += board[a1][b1] + board[b1][a1];
            }
        }

        return Math.abs(startSum - linkSum);

    }

}
