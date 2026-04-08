package 백준.실버.level2;

import java.util.*;
import java.io.*;

public class DFS와BFS2 {
    static int N, M, V;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        //visited = new boolean[N+1];

        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);

        }

        for(int i=1;i<=N;i++){
            Collections.sort(list.get(i));
        }

        visited = new boolean[N+1];
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);


    }

    static void dfs(int start){
        //visited = new boolean[N+1];
        visited[start] = true;
        System.out.print(start + " ");
        for(int i=0;i<list.get(start).size();i++){
            int next = list.get(start).get(i);
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        //visited = new boolean[N+1];
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            System.out.print(now + " ");
            for(int i=0;i<list.get(now).size();i++){
                int next = list.get(now).get(i);
                if(!visited[next]){
                    q.offer(next);
                    visited[next] = true;
                }
            }

        }
    }

}
