package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 가장먼노드9 {
    static ArrayList<ArrayList<Integer>> edges;
    static int[] d;
    static boolean[] visited;
    static int n1;

    public static int solution(int n, int[][] edge){
        n1 = n;
        int answer = 0;

        edges = new ArrayList<>();
        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        for(int[] e : edge){
            int a = e[0];
            int b = e[1];

            edges.get(a).add(b);
            edges.get(b).add(a);

        }

        bfs(1);

        int maxdist = Integer.MIN_VALUE;
        for(int x: d){
            maxdist = Math.max(maxdist, x);
        }

        for(int i=1;i<=n;i++){
            if(maxdist == d[i]) answer++;
        }

        return answer;

    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n1+1];
        d = new int[n1+1];

        q.offer(start);
        visited[start] = true;
        d[start] = 0;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
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
        int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};

        System.out.println(solution(n,edge));
    }

}
