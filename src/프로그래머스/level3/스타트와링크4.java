package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 스타트와링크4 {

    static int N,M;
    static int[][] map;
    static int answer;
    static List<Integer> start;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = N / 2;

        map = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;
        visited = new boolean[N+1];
        dfs(1,0);

        System.out.println(answer);

    }

    static void dfs(int node, int count){
        if(count == M){
            answer = Math.min(answer, calculate());
            return;
        }

        for(int i=node;i<=N;i++){
            //if(!visited[i]){
            visited[i] = true;
            dfs(i+1, count+1);
            visited[i] = false;
            //}
        }

    }

    static int calculate(){

        int start  =0;
        int link = 0;

        for(int i=1;i<=N;i++){
            for(int j=i+1;j<=N;j++){
                if(visited[i] && visited[j]){
                    start += map[i][j] + map[j][i];
                }

                if(!visited[i] && !visited[j]){
                    link += map[i][j] + map[j][i];
                }
            }
        }

        return Math.abs(start - link);
    }

}
