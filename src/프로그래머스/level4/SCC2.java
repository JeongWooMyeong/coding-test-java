package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class SCC2 {

    static int V,E;
    static ArrayList<ArrayList<Integer>> edges;
    static ArrayList<ArrayList<Integer>> reversed;
    static boolean[] visited;
    static ArrayList<Integer> order;
    static ArrayList<ArrayList<Integer>> sccList;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        reversed = new ArrayList<>();
        sccList = new ArrayList<>();
        visited = new boolean[V+1];

        for(int i=0;i<=V;i++){
            edges.add(new ArrayList<>());
            reversed.add(new ArrayList<>());
        }

        order = new ArrayList<>();

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

            ArrayList<Integer> scc = new ArrayList<>();

            dfs2(start, scc);

            Collections.sort(scc);

            sccList.add(scc);

        }

        sccList.sort((a,b)-> Integer.compare(a.get(0), b.get(0)));

        StringBuilder sb = new StringBuilder();

        for(ArrayList<Integer> scc : sccList){
            for(int x : scc){
                sb.append(x).append(" ");
            }
            sb.append("-1\n");
        }

        System.out.println(sb);

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

    static void dfs2(int start, ArrayList<Integer> scc){
        visited[start] = true;

        scc.add(start);

        for(int next : reversed.get(start)){
            if(!visited[next]){
                dfs2(next, scc);
            }
        }

    }

}
