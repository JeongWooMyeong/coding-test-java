package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 저울2 {
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
            int count = 0;
            visited = new boolean[N+1];

            bfs(i, graph, visited);
            bfs(i, reversegraph, visited);

            for(int j=1;j<=N;j++){
                if(i == j) continue;
                if(!visited[j]){
                    count++;
                }
            }
            System.out.println(count);

        }
    }

    static void bfs(int start, ArrayList<ArrayList<Integer>> graph, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<graph.get(now).size();i++){
                int next = graph.get(now).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
