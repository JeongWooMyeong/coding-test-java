package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
내가 생각한대로 짠건 한가지 경로만 탐색해서
다른 방향으로 이어진 경로에 대한 탐색을 할 수 없음
X
 */

public class 양과늑대 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int n;
    static int answer = Integer.MIN_VALUE;

    public static int solution(int[] info, int[][] edges){
        n = info.length;
        visited = new boolean[n];
        graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            //graph.get(b).add(a);
        }

        dfs(0,1,0,info);

        return answer;
    }

    static void dfs(int idx, int sheep, int wolf, int[] info){
        answer = Math.max(answer, sheep);

        for(int i=0;i<graph.get(idx).size();i++){
            int next = graph.get(idx).get(i);
            if(!visited[next] && sheep > wolf){
                visited[next] = true;
                if(info[next] == 0){
                    dfs(next, sheep+1, wolf, info);
                }else{
                    dfs(next, sheep, wolf+1, info);
                }
                visited[next] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        System.out.println(solution(info, edges));
    }

}
