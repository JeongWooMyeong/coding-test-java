package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 양과늑대2 {
    static int answer = Integer.MIN_VALUE;
    static ArrayList<ArrayList<Integer>> graph;
    static int n;

    public static int solution(int[] info, int[][] edges){
        n = info.length;
        graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int parent = e[0];
            int child = e[1];

            graph.get(parent).add(child);
        }

        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);

        dfs(0,0, nextNodes, info);

        return answer;

    }

    static void dfs(int sheep, int wolf, List<Integer> nextNodes, int[] info){
        answer = Math.max(sheep, answer);

        for(int current : nextNodes){
            int ns = sheep;
            int nw = wolf;

            if(info[current] == 0){
                ns++;
            }else{
                nw++;
            }
            //늑대가 양보다 크거나 같으면 실행하지 않음 (잡아먹힘)
            if(nw >= ns) continue;

            List<Integer> candidates = new ArrayList<>(nextNodes);
            candidates.remove(Integer.valueOf(current));

            //자식 노드 담기
            for(int child : graph.get(current)){
                candidates.add(child);
            }

            dfs(ns,nw, candidates, info);

        }
    }

    public static void main(String[] args) throws Exception{
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        System.out.println(solution(info, edges));
    }

}
