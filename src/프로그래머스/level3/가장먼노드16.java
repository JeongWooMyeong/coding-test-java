package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 가장먼노드16 {

    static int[] d;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int n1;

    public static int solution(int n, int[][] edges){
        graph = new ArrayList<>();
        n1 = n;

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int a = e[0];
            int b = e[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);

        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            max = Math.max(max, d[i]);
        }

        int answer = 0;
        for(int i=1;i<=n;i++){
            if(d[i] == max) answer++;
        }

        return answer;
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        d = new int[n1+1];
        visited = new boolean[n1+1];
        q.offer(start);
        d[start] = 0;
        visited[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<graph.get(now).size();i++){
                int next =graph.get(now).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    d[next] = d[now] + 1;
                    q.offer(next);
                }
            }
        }


    }

    public static void main(String[] args) throws Exception{
        int n = 6;
        int[][] vertex = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};

        System.out.println(solution(n, vertex));
    }


}
