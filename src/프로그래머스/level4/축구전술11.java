package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 축구전술11 {

    static int T,N,M;
    static List<List<Integer>> edges;
    static List<List<Integer>> reversed;
    static List<Integer> order;
    static List<List<Integer>> sccList;
    static StringBuilder sb;
    static boolean[] visited;
    static int[] sccId;
    static int sccCount;
    static int zeroCount;
    static int answerseq;
    static int[] indegree;

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
            reversed = new ArrayList<>();
            visited = new boolean[N];

            for(int i=0;i<N;i++){
                edges.add(new ArrayList<>());
                reversed.add(new ArrayList<>());
            }

            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                edges.get(a).add(b);
                reversed.get(b).add(a);
            }

            order = new ArrayList<>();
            sccList = new ArrayList<>();

            for(int i=0;i<N;i++){
                if(!visited[i]){
                    dfs(i);
                }
            }

            Arrays.fill(visited, false);
            sccCount = 0;
            sccId = new int[N];

            for(int i=order.size()-1;i>=0;i--){
                int cur = order.get(i);

                if(visited[cur]) continue;

                List<Integer> scc = new ArrayList<>();

                dfs2(cur, scc);

                Collections.sort(scc);

                sccList.add(scc);
                sccCount++;

            }

            indegree = new int[sccCount];

            for(int i=0;i<N;i++){
                for(int next : edges.get(i)){
                    if(sccId[i] != sccId[next]){
                        indegree[sccId[next]]++;
                    }
                }
            }

            zeroCount = 0;
            answerseq = -1;

            for(int i=0;i<sccCount;i++){
                if(indegree[i] == 0){
                    zeroCount++;
                    answerseq = i;
                }
            }

            if(zeroCount != 1) sb.append("Confused").append("\n");
            else{
                List<Integer> scc = sccList.get(answerseq);
                for(int x : scc){
                    sb.append(x).append(" ").append("\n");
                }
            }

            sb.append("\n");

        }

        System.out.println(sb);
    }

    static void dfs(int start){
        visited[start] = true;

        for(int i=0;i<edges.get(start).size();i++){
            int next = edges.get(start).get(i);

            if(!visited[next]) {
                dfs(next);
            }
        }

        order.add(start);

    }

    static void dfs2(int start, List<Integer> scc){
        visited[start] = true;
        sccId[start] = sccCount;
        scc.add(start);

        for(int i=0;i<reversed.get(start).size();i++){
            int next = reversed.get(start).get(i);

            if(!visited[next]){
                dfs2(next, scc);
            }

        }
    }

}
