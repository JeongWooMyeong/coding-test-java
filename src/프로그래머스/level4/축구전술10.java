package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 축구전술10 {

    static int T,N,M;
    static List<List<Integer>> edges;
    static StringBuilder sb;
    static int[] id;
    static int[] low;
    static Stack<Integer> stack;
    static boolean[] onStack;
    static int[] sccId;
    static int[] indegree;
    static int sccCount;
    static int counter;
    static List<List<Integer>> sccList;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        String line;
        sb = new StringBuilder();

        while(T-- > 0){
            do{
                line = br.readLine();
            }while(line != null && line.trim().isEmpty());

            st = new StringTokenizer(line);

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();
            for(int i=0;i<N;i++) edges.add(new ArrayList<>());

            id = new int[N];
            low = new int[N];
            stack = new Stack<>();
            onStack = new boolean[N];
            sccList = new ArrayList<>();
            sccCount = 0;
            counter = 0;
            sccId = new int[N];

            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                edges.get(a).add(b);

            }

            for(int i=0;i<N;i++){
                if(id[i] == 0){
                    dfs(i);
                }
            }

            //sccList.sort(Comparator.comparingInt(a->a.get(0)));

            indegree = new int[sccCount];

            for(int i=0;i<N;i++){
                for(int next : edges.get(i)){
                    if(sccId[i] != sccId[next]){
                        indegree[sccId[next]]++;
                    }
                }
            }

            int zeroCount = 0;
            int answerseq = -1;

            for(int i=0;i<sccCount;i++){
                if(indegree[i] == 0){
                    zeroCount++;
                    answerseq = i;
                }
            }

            if(zeroCount != 1) sb.append("Confused").append("\n\n");
            else{
                List<Integer> scc = sccList.get(answerseq);

                for(int x : scc){
                    sb.append(x).append("\n");
                }
                sb.append("\n");

            }
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

        if(id[start] == low[start]){
            List<Integer> scc = new ArrayList<>();

            while(true){
                int cur = stack.pop();
                onStack[cur] = false;

                scc.add(cur);
                sccId[cur] = sccCount;

                if(cur == start) break;

            }

            Collections.sort(scc);
            sccList.add(scc);
            sccCount++;

        }

    }

}
