package 백준.골드.level4;

import java.util.*;
import java.io.*;

/*
DFS
 */

public class 저울3 {
    static int N,M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> reversegraph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
            reversegraph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            reversegraph.get(b).add(a);

        }

        for(int i=1;i<=N;i++){
            visited = new boolean[N+1];
            dfs(i, graph);
            dfs(i, reversegraph);

            int count = 0;
            for(int j=1;j<=N;j++){
                if(i==j) continue;
                if(!visited[j]) count++;
            }

            System.out.println(count);
        }




    }

    static void dfs(int start, ArrayList<ArrayList<Integer>> graph){
        visited[start] = true;
        for(int i=0;i<graph.get(start).size();i++){
            int next = graph.get(start).get(i);
            if(!visited[next]){
                //visited[next] = true;
                dfs(next, graph);
            }
        }
    }

}
