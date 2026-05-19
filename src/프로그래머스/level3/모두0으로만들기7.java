package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 모두0으로만들기7 {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] values;
    static long answer;
    static int n;
    //static boolean[] visited;

    public static long solution(int[] a, int[][] edges){
        answer = 0;
        n = a.length;

        //visited = new boolean[n];
        values = new int[n];

        long sum = 0;
        for(int i=0;i<n;i++){
            values[i] = a[i];
            sum += a[i];
        }

        if(sum != 0 ) return -1;

        graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int a1 = e[0];
            int b1 = e[1];

            graph.get(a1).add(b1);
            graph.get(b1).add(a1);
        }

        dfs(0, -1);


        return answer;
    }

    static long dfs(int node, int parent){
        long sum = values[node];
        //visited[node] = true;

        for(int i=0;i<graph.get(node).size();i++){
            int next = graph.get(node).get(i);
            if(next == parent) continue;

            long child = dfs(next, node);
            sum += child;

        }

        answer += Math.abs(sum);


        return sum;
    }

    public static void main(String[] args) throws Exception{
        int[] a = {-5,0,2,1,2};
        int[][] edges = {{0,1},{3,4},{2,3},{0,3}};
        System.out.println(solution(a, edges));
    }

}
