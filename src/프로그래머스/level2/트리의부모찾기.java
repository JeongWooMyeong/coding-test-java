package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 트리의부모찾기 {
    static int[] parent;
    static ArrayList<ArrayList<Integer>> edges;
    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        edges = new ArrayList<>();
        visited = new boolean[N+1];

        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(b);
            edges.get(b).add(a);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();

        for(int i=2;i<=N;i++){
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb.toString());

    }

    static void dfs(int start){
        visited[start] = true;

        for(int i=0;i<edges.get(start).size();i++){
            int child = edges.get(start).get(i);
            if(!visited[child]) {
                parent[child] = start;
                dfs(child);
            }
        }

    }

}
