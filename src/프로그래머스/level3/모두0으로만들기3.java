package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 모두0으로만들기3 {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] values;
    static long answer;
    static int n;
    static boolean[] visited;

    public static long solution(int[] a, int[][] edges){
        graph = new ArrayList<>();
        values = new int[a.length];
        answer = 0;
        n = a.length;
        visited = new boolean[n];

        int sum = 0;
        for(int i=0;i<a.length;i++){
            values[i] = a[i];
            sum += a[i];
        }
        //총합이 0이 아니라면 모든 가중치를 0으로 만들 수 없음
        if(sum != 0) return -1;
        //간선 담기
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int a1 = e[0];
            int b1 = e[1];

            graph.get(a1).add(b1);
            graph.get(b1).add(a1);
        }

        //0부터 시작
        dfs(0);

        return answer;
    }

    static long dfs(int node){
        visited[node] = true;
        long sum = values[node];

        for(int i=0;i<graph.get(node).size();i++){
            int next = graph.get(node).get(i);
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
