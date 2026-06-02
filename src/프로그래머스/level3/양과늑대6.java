package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 양과늑대6 {

    static ArrayList<ArrayList<Integer>> graph;
    static int n;
    static int answer;

    public static int solution(int[] info, int[][] edges){
        answer = Integer.MIN_VALUE;
        n = info.length;
        graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int parent = e[0];
            int child = e[1];

            graph.get(parent).add(child);
        }

        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);

        dfs(0,0,nextNodes,info);

        return answer;
    }

    static void dfs(int sheep, int wolf, List<Integer> nextNodes, int[] info){
        answer = Math.max(answer, sheep);
        for(int current : nextNodes){
            int ns = sheep;
            int nw = wolf;

            if(info[current] == 0){
                ns++;
            }else{
                nw++;
            }

            if(nw >= ns) continue;

            List<Integer> candidates = new ArrayList<>(nextNodes);
            candidates.remove(Integer.valueOf(current));
            candidates.addAll(graph.get(current));

            dfs(ns,nw,candidates,info);

        }
    }

    public static void main(String[] args) throws Exception{
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        System.out.println(solution(info, edges));
    }

}
