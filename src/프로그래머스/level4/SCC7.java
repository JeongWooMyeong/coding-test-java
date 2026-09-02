package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class SCC7 {

    static int V,E;
    static List<List<Integer>> edges;
    static List<List<Integer>> reversed;
    static List<Integer> order;
    static List<List<Integer>> sccList;
    static StringBuilder sb;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        reversed = new ArrayList<>();
        for(int i=0;i<=V;i++) {
            edges.add(new ArrayList<>());
            reversed.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(b);
            reversed.get(b).add(a);
        }

        visited = new boolean[V+1];
        order = new ArrayList<>();
        sb = new StringBuilder();
        sccList = new ArrayList<>();

        for(int i=1;i<=V;i++){
            if(!visited[i]){
                dfs1(i);
            }
        }

        Arrays.fill(visited, false);

        for(int i=order.size()-1;i>=0;i--){
            int start = order.get(i);

            if(visited[start]) continue;

            List<Integer> scc = new ArrayList<>();

            dfs2(start, scc);

            Collections.sort(scc);

            sccList.add(scc);

        }

        sccList.sort((a,b)->a.get(0) - b.get(0));

        sb.append(sccList.size()).append("\n");

        for(List<Integer> scc : sccList){
            for(int x : scc){
                sb.append(x).append(" ");
            }
            sb.append("-1").append("\n");
        }

        System.out.println(sb);

    }

    static void dfs1(int start){
        visited[start] = true;

        for(int i=0;i<edges.get(start).size();i++){
            int next = edges.get(start).get(i);
            if(!visited[next]){
                dfs1(next);
            }
        }

        order.add(start);

    }

    static void dfs2(int start, List<Integer> scc){
        visited[start] = true;
        scc.add(start);

        for(int i=0;i<reversed.get(start).size();i++){
            int next = reversed.get(start).get(i);
            if(!visited[next]){
                dfs2(next, scc);
            }
        }

    }

}
