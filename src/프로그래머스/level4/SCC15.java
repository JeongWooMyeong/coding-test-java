package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class SCC15 {

    static int V,E;
    static List<List<Integer>> edges;
    static int counter;
    static int[] visited;
    static int[] low;
    static Stack<Integer> stack;
    static boolean[] onStack;
    static List<List<Integer>> sccList;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        visited = new int[V+1];
        low = new int[V+1];
        stack = new Stack<>();
        onStack = new boolean[V+1];
        sccList = new ArrayList<>();
        sb = new StringBuilder();

        for(int i=0;i<=V;i++) edges.add(new ArrayList<>());

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(b);
        }

        counter = 0;

        for(int i=1;i<=V;i++){
            if(visited[i] == 0){
                dfs(i);
            }
        }

        sccList.sort(Comparator.comparingInt(a->a.get(0)));

        sb.append(sccList.size()).append("\n");

        for(List<Integer> scc : sccList){
            for(int x : scc){
                sb.append(x).append(" ");
            }
            sb.append("-1").append("\n");
        }


        System.out.println(sb);
    }

    static void dfs(int start){
        visited[start] = low[start] = ++counter;

        stack.push(start);
        onStack[start] = true;

        for(int i=0;i<edges.get(start).size();i++){
            int next = edges.get(start).get(i);

            if(visited[next] == 0){
                dfs(next);
                low[start] = Math.min(low[start], low[next]);
            }else if(onStack[next]){
                low[start] = Math.min(low[start], visited[next]);
                //dfs(next);

            }
        }

        if(visited[start] == low[start]){

            List<Integer> scc = new ArrayList<>();

            while(true){
                int node = stack.pop();
                onStack[node] = false;
                scc.add(node);

                if(node == start){
                    break;
                }

            }

            Collections.sort(scc);
            sccList.add(scc);
        }


    }

}
