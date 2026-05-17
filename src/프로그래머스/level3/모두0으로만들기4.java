package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 모두0으로만들기4 {
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> graph;
    static long answer;
    static long[] values;
    static int n;

    public static long solution(int[] a, int[][] edges){
        n = a.length;
        answer = 0;
        indegree = new int[n];
        graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        long sum = 0;
        values = new long[n];
        for(int i=0;i<a.length;i++){
            sum += a[i];
            values[i] = a[i];
        }

        if(sum != 0) return -1;

        for(int[] e : edges){
            int a1 = e[0];
            int b1 = e[1];

            graph.get(a1).add(b1);
            graph.get(b1).add(a1);

            indegree[a1] += 1;
            indegree[b1] += 1;

        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indegree[i] == 1){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            answer += Math.abs(values[now]);

            for(int i=0;i<graph.get(now).size();i++){
                int next = graph.get(now).get(i);
                if(indegree[next] > 0){
                    values[next] += values[now];
                    indegree[next]--;
                    if(indegree[next] == 1) q.add(next);
                }
            }

            indegree[now] = 0;
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        int[] a = {-5,0,2,1,2};
        int[][] edges = {{0,1},{3,4},{2,3},{0,3}};
        System.out.println(solution(a, edges));
    }

}
