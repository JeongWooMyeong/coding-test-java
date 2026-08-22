package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 축구전술2 {

    static int T, N, M;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> edges;
    static ArrayList<ArrayList<Integer>> reversed;
    static int[] sccId;
    static ArrayList<Integer> order;
    static ArrayList<ArrayList<Integer>> sccList;

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

            sccId = new int[N];

            sccList = new ArrayList<>();

            int sccCount = 0;
            Arrays.fill(sccId, -1);
            //역순
            for(int i=order.size()-1;i>=0;i--){
                int start = order.get(i);

                if(visited[start]) continue;

                ArrayList<Integer> scc = new ArrayList<>();

                dfs2(start, scc, sccCount);

                sccList.add(scc);

                sccCount++;

            }

            //진입차수
            int[] indegree = new int[sccCount];

            for(int cur=0;cur<N;cur++){
                for(int next : edges.get(cur)){
                    if(sccId[cur] != sccId[next]){
                        indegree[sccId[next]]++;
                    }
                }
            }

            //진입차수 0인거 찾기
            int zeroCount = 0;
            int answerScc = -1;

            for(int i=0;i<sccCount;i++){
                if(indegree[i] == 0){
                    zeroCount++;
                    answerScc = i;
                }
            }


            if(zeroCount != 1){
                sb.append("Confused\n");
            }else{
                ArrayList<Integer> answer = sccList.get(answerScc);

                Collections.sort(answer);

                for(int x : answer){
                    sb.append(x).append(" ");
                }

            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void dfs1(int cur){
        visited[cur] = true;

        for(int next : edges.get(cur)){
            if(!visited[next]){
                dfs1(next);
            }
        }

        order.add(cur);

    }

    static void dfs2(int cur, ArrayList<Integer> scc, int id){
        visited[cur] = true;
        scc.add(cur);
        sccId[cur] = id;

        for(int next : reversed.get(cur)){
            if(!visited[next]){
                dfs2(next,scc,id);
            }
        }

    }

}
