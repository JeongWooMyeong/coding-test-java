package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class SCC17 {

    static int V,E, counter;
    static List<List<Integer>> edges;
    static Stack<Integer> stack;
    static int[] id;
    static int[] low;
    static boolean[] onStack;
    static StringBuilder sb;
    static List<List<Integer>> sccList;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for(int i=0;i<=V;i++){
            edges.add(new ArrayList<>());
        }

        stack = new Stack<>();
        id = new int[V+1];
        low = new int[V+1];
        onStack = new boolean[V+1];
        sb = new StringBuilder();
        sccList = new ArrayList<>();

        counter = 0;

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(b);
        }

        for(int i=1;i<=V;i++){
            if(id[i] == 0){
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
        id[start] = low[start] = ++counter;

        stack.push(start);
        onStack[start] = true;

        for(int i=0;i<edges.get(start).size();i++){
            int next = edges.get(start).get(i);

            if(id[next] == 0){
                dfs(next);
                low[start] = Math.min(low[start], low[next]);
            }else if(onStack[next]){
                low[start] = Math.min(low[start], id[next]);
            }
        }

        if(low[start] == id[start]){
            List<Integer> scc = new ArrayList<>();

            while(true){
                int cur = stack.pop();
                onStack[cur] = false;

                scc.add(cur);

                if(cur == start) break;

            }

            Collections.sort(scc);

            sccList.add(scc);
        }

    }

}
