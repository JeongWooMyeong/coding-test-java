package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class SCC {

    static int V,E;

    static ArrayList<Integer>[] graph;
    static ArrayList<Integer>[] reverseGraph;

    static boolean[] visited;

    //1차 DFS가 끝난 순서
    static ArrayList<Integer> order = new ArrayList<>();
    //SCC 결과
    static ArrayList<ArrayList<Integer>> sccList = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        reverseGraph = new ArrayList[V+1];

        for(int i=1;i<=V;i++){
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);

            reverseGraph[b].add(a);
        }

        //1차 DFS
        visited = new boolean[V+1];

        for(int i=1;i<=V;i++){
            if(!visited[i]){
                dfs1(i);
            }
        }

        //2차 DFS

        Arrays.fill(visited, false);

        //1차 DFS가 끝난 순서의 역순
        for(int i=order.size()-1;i>=0;i--){
            int start = order.get(i);

            if(visited[start]) continue;

            ArrayList<Integer> scc = new ArrayList<>();

            dfs2(start, scc);

            Collections.sort(scc);

            sccList.add(scc);

        }

        sccList.sort(
                (a,b)->Integer.compare(a.get(0), b.get(0))
        );

        StringBuilder sb = new StringBuilder();

        sb.append(sccList.size()).append("\n");

        for(ArrayList<Integer> scc : sccList){
            for(int vertex : scc){
                sb.append(vertex).append(' ');
            }

            sb.append("-1\n");
        }

        System.out.print(sb);

    }

    static void dfs1(int cur){
        visited[cur] = true;

        for(int next : graph[cur]){
            if(!visited[next]){
                dfs1(next);
            }
        }

        order.add(cur);
    }

    static void dfs2(int cur, ArrayList<Integer> scc){
        visited[cur] = true;

        scc.add(cur);

        for(int next : reverseGraph[cur]){
            if(!visited[next]){
                dfs2(next, scc);
            }
        }

    }

}
