package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 트리의부모찾기4 {

    static ArrayList<ArrayList<Integer>> edges;
    static int[] parent;
    static StringBuilder sb;
    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        edges = new ArrayList<>();
        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        parent = new int[N+1];

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(b);
            edges.get(b).add(a);
        }

        bfs(1);

        sb = new StringBuilder();
        for(int i=2;i<=N;i++){
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N+1];
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    parent[next] = now;
                    q.offer(next);
                }
            }

        }

    }

}
