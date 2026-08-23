package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 축구전술3 {

    static int T,N,M;
    static ArrayList<ArrayList<Integer>> edges;
    static ArrayList<ArrayList<Integer>> reversed;
    static ArrayList<ArrayList<Integer>> sccList;
    static int[] sccId;
    static boolean[] visited;
    static ArrayList<Integer> order;
    static int[] indegree;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();
            reversed = new ArrayList<>();
            sccList = new ArrayList<>();
            order = new ArrayList<>();

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

            for(int i=0;i<N;i++){
                if(!visited[i]){
                    dfs1(i);
                }
            }

            Arrays.fill(visited, false);
            int sccCount = 0;
            sccId = new int[N];
            Arrays.fill(sccId, -1);

            for(int i=order.size()-1;i>=0;i--){
                int start = order.get(i);

                if(visited[start]) continue;

                ArrayList<Integer> scc = new ArrayList<>();

                dfs2(start, scc, sccCount);

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

            int zeroCount = 0;
            int answerSeq = -1;

            for(int i=0;i<sccCount;i++){
                if(indegree[i] == 0){
                    zeroCount++;
                    answerSeq = i;
                }
            }


            if(zeroCount != 1){
                sb.append("Confused \n");
            }else{
                ArrayList<Integer> answer = sccList.get(answerSeq);

                Collections.sort(answer);

                for(int x : answer){
                    sb.append(x).append(" ");
                }

                sb.append("\n");
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

    static void dfs2(int start, ArrayList<Integer> scc, int id){
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
