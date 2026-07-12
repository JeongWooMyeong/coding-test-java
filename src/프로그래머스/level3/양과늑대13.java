package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 양과늑대13 {

    static ArrayList<ArrayList<Integer>> graph;
    static int n;
    static int answer;

    public static int solution(int[] info, int[][] edges){
        n = info.length;
        answer = Integer.MIN_VALUE;

        graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int parent = e[0];
            int child = e[1];

            graph.get(parent).add(child);
        }

        List<Integer> nextNodes = new ArrayList<>(graph.get(0));
        int sheep = info[0] == 0 ? 1 : 0;
        int wolf = info[0] == 1 ? 1 : 0;

        dfs(sheep, wolf, nextNodes, info);

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
        int[] info = {0,1,0,1,1,0,1,0,0,1,0};
        int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}};

        System.out.println(solution(info, edges));
    }

}
