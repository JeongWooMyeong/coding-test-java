package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 축구전술6 {

    static int T,N,M;
    static List<List<Integer>> edges;
    static List<List<Integer>> reversed;
    static boolean[] visited;
    static List<Integer> order;
    static List<List<Integer>> sccList;
    static int[] indegree;
    static int[] sccId;
    static StringBuilder sb;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        String line;
        while(T-- > 0){
            do{
                line = br.readLine();
            }while(line.trim().isEmpty());

            st = new StringTokenizer(line);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();
            reversed = new ArrayList<>();
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

            visited = new boolean[N];
            order = new ArrayList<>();
            sccList = new ArrayList<>();

            for(int i=0;i<N;i++){
                if(!visited[i]){
                    dfs1(i);
                }
            }

            Arrays.fill(visited, false);
            int sccCount = 0;
            sccId = new int[N];

            for(int i=order.size()-1;i>=0;i--){
                int start = order.get(i);
                if(visited[start]) continue;

                List<Integer> scc = new ArrayList<>();

                dfs2(start, scc, sccCount);

                Collections.sort(scc);

                sccList.add(scc);

                sccCount++;

            }

            indegree = new int[sccCount];
            for(int cur=0;cur<N;cur++){
                for(int next : edges.get(cur)){
                    if(sccId[cur] != sccId[next]){
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

            if(zeroCount != 1){
                sb.append("Confused\n");
            }else{
                List<Integer> answer = sccList.get(answerseq);
                Collections.sort(answer);
                for(int x : answer){
                    sb.append(x).append("\n");
                }
            }

            sb.append("\n");
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

    static void dfs2(int start, List<Integer> scc, int id){
        visited[start] = true;

        sccId[start] = id;

        scc.add(start);

        for(int next : reversed.get(start)){
            if(!visited[next]){
                dfs2(next, scc, id);
            }
        }
    }

}
