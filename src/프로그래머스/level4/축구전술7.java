package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 축구전술7 {

    static int T;
    static int N,M;
    static boolean[] visited;
    static List<Integer> order;
    static List<List<Integer>> edges;
    static List<List<Integer>> reversed;
    static List<List<Integer>> sccList;
    static int[] sccId;
    static int[] indegree;
    static StringBuilder sb;
    static List<Integer> answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();
            reversed = new ArrayList<>();
            order = new ArrayList<>();
            visited = new boolean[N];
            sccList = new ArrayList<>();
            sccId = new int[N];
            answer = new ArrayList<>();

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

                List<Integer> scc = new ArrayList<>();

                dfs2(start, scc, sccCount);

                sccCount++;
                sccList.add(scc);

            }

            indegree = new int[sccCount];
            for(int cur=0;cur<N;cur++){
                for(int next : edges.get(cur)){
                    if(sccId[cur] != sccId[next]){
                        indegree[sccId[next]]++;
                    }
                }
            }

            int answerseq = -1;
            int zeroCount = 0;

            for(int i=0;i<sccCount;i++){
                if(indegree[i] == 0){
                    zeroCount++;
                    answerseq = i;
                }
            }

            if(zeroCount != 1){
                sb.append("Confused").append("\n");
            }else{
                answer = sccList.get(answerseq);
                Collections.sort(answer);
                for(int x : answer){
                    sb.append(x).append("\n");
                }
            }

        }

        System.out.println(sb);

    }

    static void dfs1(int start){
        visited[start] = true;

        for(int i=0;i<edges.get(start).size();i++){
            int next = edges.get(start).get(i);
            if(!visited[next]){
                dfs1(next);
            }
        }

        order.add(start);
    }

    static void dfs2(int start, List<Integer> scc, int id){
        visited[start] = true;
        sccId[start] = id;
        //sccList.add(scc);
        scc.add(start);

        for(int i=0;i<reversed.get(start).size();i++){
            int next = reversed.get(start).get(i);
            if(!visited[next]){
                dfs2(next, scc, id);
            }
        }

    }

}
