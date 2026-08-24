package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 축구전술4 {

    static int T;
    static int N,M;
    static ArrayList<ArrayList<Integer>> edges;
    static ArrayList<ArrayList<Integer>> reversed;
    static StringBuilder sb;
    static int[] sccId;
    static int[] indegree;
    static boolean[] visited;
    static ArrayList<Integer> order;
    static ArrayList<ArrayList<Integer>> sccList;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        String line;

        while(T-- > 0){

            do{
                line = br.readLine();
            } while(line.trim().isEmpty());

            st = new StringTokenizer(line);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            sccId = new int[N];
            indegree = new int[N];
            visited = new boolean[N];
            edges = new ArrayList<>();
            reversed = new ArrayList<>();
            order = new ArrayList<>();
            sccList = new ArrayList<>();

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

            for(int i=0;i<N;i++){
                if(!visited[i]){
                    dfs1(i);
                }
            }

            Arrays.fill(visited, false);

            int sccCount = 0;

            for(int i=order.size()-1;i>=0;i--){
                int start = order.get(i);

                if(visited[start]) continue;

                ArrayList<Integer> scc = new ArrayList<>();

                dfs2(start, scc, sccCount);

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
                sb.append("Confused").append("\n");
            }else{
                List<Integer> scc = sccList.get(answerseq);
                Collections.sort(scc);
                for(int x : scc){
                    sb.append(x).append("\n");
                }
            }

            sb.append("\n");
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

    static void dfs2(int start, List<Integer> scc, int id){
        visited[start] = true;
        scc.add(start);
        sccId[start] = id;

        for(int next : reversed.get(start)){
            if(!visited[next]){
                dfs2(next, scc, id);
            }
        }

    }

}
