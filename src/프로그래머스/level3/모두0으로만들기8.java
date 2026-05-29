package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 모두0으로만들기8 {

    static int[] values;
    static ArrayList<ArrayList<Integer>> graph;
    static int n;
    //static boolean[] visited;
    static long answer;

    public static long solution(int[] a, int[][] edges){
        answer = 0;
        graph = new ArrayList<>();
        n = a.length;

        values = new int[a.length];

        int sum = 0;
        for(int i=0;i<a.length;i++){
            values[i] = a[i];
            sum += a[i];
        }

        if(sum != 0) return -1;

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int a1 = e[0];
            int b1 = e[1];

            graph.get(a1).add(b1);
            graph.get(b1).add(a1);
        }

        //visited = new boolean[n];
        dfs(0, -1);


        return answer;
    }

    static long dfs(int node, int parent){
        //visited[node] = true;
        long sum = (long)values[node];

        for(int i=0;i<graph.get(node).size();i++){{
            int next = graph.get(node).get(i);
            if(next == parent) continue;

            long child = dfs(next, node);
            sum += child;
        }}


        answer += Math.abs(sum);

        return sum;

    }

    public static void main(String[] args) throws Exception{
        int[] a = {-5,0,2,1,2};
        int[][] edges = {{0,1},{3,4},{2,3},{0,3}};
        System.out.println(solution(a, edges));
    }

}
