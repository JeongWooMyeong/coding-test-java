package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class SCC5 {

    static int V,E;
    static List<List<Integer>> edges;
    static List<Integer> order;
    static List<List<Integer>> reversed;
    static boolean[] visited;
    static List<List<Integer>> sccList;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        order = new ArrayList<>();
        reversed = new ArrayList<>();
        edges = new ArrayList<>();
        visited = new boolean[V+1];
        sccList = new ArrayList<>();
        sb = new StringBuilder();

        for(int i=0;i<=V;i++){
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

        sccList.sort((a,b)->Integer.compare(a.get(0),b.get(0)));

        sb.append(sccList.size()).append("\n");

        for(List<Integer> scc : sccList){
            for(int x : scc){
                sb.append(x).append(" ");
            }
            sb.append("-1\n");
        }

        System.out.print(sb);

    }

    static void dfs1(int start){
        visited[start] = true;

        for(int next : edges.get(start)){
            if(!visited[next]){
                dfs1(next);
            }
        }

        order.add(start);

    }

    static void dfs2(int start, List<Integer> scc){
        visited[start] = true;
        scc.add(start);

        for(int next : reversed.get(start)){
            if(!visited[next]){
                dfs2(next, scc);
            }
        }

    }

}
