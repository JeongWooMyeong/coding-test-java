package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 양과늑대3 {
    static ArrayList<ArrayList<Integer>> graph;
    static int n;
    static int answer = Integer.MIN_VALUE;

    public static int solution(int[] info, int[][] edges){
        //int answer = 0;
        n = info.length;

        graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int a = e[0];
            int b = e[1];
            //부모, 자식이므로 양방향 아님
            graph.get(a).add(b);

        }

        ArrayList<Integer> nextnodes = new ArrayList<>();
        nextnodes.add(0);

        dfs(0,0, nextnodes, info);

        return answer;
    }

    static void dfs(int sheep, int wolf, ArrayList<Integer> nextnodes, int[] info){
        answer = Math.max(answer, sheep);

        for(int i=0;i<nextnodes.size();i++){
            int next = nextnodes.get(i);

            //양과 늑대 계산
            int nw = wolf;
            int ns = sheep;

            if(info[next] == 0){
                ns++;
            }else{
                nw++;
            }

            if(nw >= ns) continue;

            ArrayList<Integer> candidates = new ArrayList<>(nextnodes);
            candidates.remove(Integer.valueOf(next));

            for(int child : graph.get(next)){
                    candidates.add(child);
            }

            dfs(ns, nw, candidates, info);

        }


    }

    public static void main(String[] args) throws Exception{
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        System.out.println(solution(info, edges));
    }
}
