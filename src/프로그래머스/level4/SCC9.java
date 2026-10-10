package 프로그래머스.level4;

/*
tarjan 알고리즘 SCC Strongly Connected Component
 */

import java.util.*;
import java.io.*;

public class SCC9 {

    static int V,E;
    static int[] id;
    static int[] low;
    static boolean[] onStack;
    static List<List<Integer>> edges;
    static Stack<Integer> stack;
    static List<List<Integer>> sccList;
    static StringBuilder sb;
    static int counter = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        id = new int[V+1];
        low = new int[V+1];
        onStack = new boolean[V+1];
        edges = new ArrayList<>();
        stack = new Stack<>();
        sccList = new ArrayList<>();

        for(int i=0;i<=V;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(b);
        }

        for(int i=1;i<=V;i++){
            if(id[i] == 0){
                tarjan(i);
            }
        }

        sb = new StringBuilder();

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

    static void tarjan(int v){
        //int counter = 0;

        id[v] = low[v] = ++counter;

        stack.push(v);
        onStack[v] = true;

        for(int i=0;i<edges.get(v).size();i++){
            int next = edges.get(v).get(i);

            if(id[next] == 0){
                tarjan(next);
                low[v] = Math.min(low[v], low[next]);
            }else if(onStack[next]){
                low[v] = Math.min(low[v], id[next]);
            }

        }

        if(low[v] == id[v]){
            List<Integer> scc = new ArrayList<>();

            while(true){
                int node = stack.pop();
                onStack[node] = false;
                scc.add(node);

                if(node == v) break;

            }

            Collections.sort(scc);
            sccList.add(scc);
        }

    }

}
