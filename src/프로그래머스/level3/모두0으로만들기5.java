package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 모두0으로만들기5 {
    static ArrayList<ArrayList<Integer>> graph;
    static long[] values;
    static int n;
    static long answer = 0;
    static boolean[] visited;

    public static long solution(int[] a, int[][] edges){
        n = a.length;
        visited = new boolean[n];
        values = new long[n];
        int sum = 0;
        for(int i=0;i<n;i++){
            values[i] = a[i];
            sum += a[i];
        }
        if(sum != 0) return -1;

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


        dfs(0);

        return answer;


    }

    static long dfs(int start){
        visited[start] = true;
        long sum = values[start];

        for(int i=0;i<graph.get(start).size();i++){
            int next = graph.get(start).get(i);
            if(!visited[next]){
                long child = dfs(next);
                answer += Math.abs(child);
                sum += child;
            }
        }

        return sum;
    }

    public static void main(String[] args) throws Exception{
        int[] a = {-5,0,2,1,2};
        int[][] edges = {{0,1},{3,4},{2,3},{0,3}};
        System.out.println(solution(a, edges));
    }

}
