package 프로그래머스.level3;

import java.util.*;
import java.io.*;
/*
DFS로도 풀 수 있음

a가 이기는 경우
a가 지는 경우 두가지 더해서
자기자신 뺀거와 같으면 카운트 증가

멋지네..

 */

public class 순위3 {
    static ArrayList<ArrayList<Integer>> win = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> lose = new ArrayList<>();

    static boolean[] visited;

    public static int solution(int n, int[][] results){
        for(int i=0;i<=n;i++){
            win.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }

        for(int[] r : results){
            int a = r[0];
            int b = r[1];

            win.get(a).add(b);
            lose.get(b).add(a);

        }

        int answer = 0;
        for(int i=1;i<=n;i++){
            visited = new boolean[n+1];
            int wincount = dfs(win, i);
            visited = new boolean[n+1];
            int losecount = dfs(lose, i);
            //승리 카운트, 패배 카운트 더하기
            if(wincount + losecount == n-1) answer++;
        }

        return answer;
    }
    //재귀
    static int dfs(ArrayList<ArrayList<Integer>> graph, int now){
        visited[now] = true;
        int cnt = 0;
        for(int i=0;i<graph.get(now).size();i++){
            int next = graph.get(now).get(i);
            if(!visited[next]){
                visited[next] = true;
                cnt += 1 + dfs(graph, next);
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception{
        int n = 5;
        int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};

        System.out.println(solution(n, results));
    }

}
