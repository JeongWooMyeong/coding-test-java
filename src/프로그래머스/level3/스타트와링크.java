package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 스타트와링크 {

    static int N, M;
    static int[][] board;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = N / 2;
        answer = Integer.MAX_VALUE;

        board = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, new ArrayList<>(), new ArrayList<>());

        System.out.println(answer);

    }


    static void dfs(int idx, List<Integer> start, List<Integer> link){
        if(start.size() == M && link.size() == M){
            answer = Math.min(answer, getDiff(start, link));
            return;
        }

        //if(idx == N+1) return;
        if(start.size() > M || link.size() > M) return;

        start.add(idx);
        dfs(idx+1, start, link);
        start.remove(start.size()-1);

        link.add(idx);
        dfs(idx+1, start, link);
        link.remove(link.size()-1);

    }

    static int getDiff(List<Integer> a, List<Integer> b){
        int startCount = 0;
        int linkCount = 0;

        for(int i=0;i<a.size();i++){
            for(int j=i+1;j<a.size();j++){
                int a1 = a.get(i);
                int b1 = a.get(j);
                startCount += board[a1][b1] + board[b1][a1];
            }
        }

        for(int i=0;i<b.size();i++){
            for(int j=i+1;j<b.size();j++){
                int a1 = b.get(i);
                int b1 = b.get(j);
                linkCount += board[a1][b1] + board[b1][a1];
            }
        }

        return Math.abs(startCount - linkCount);
    }

}
