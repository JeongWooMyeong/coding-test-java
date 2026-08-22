package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 축구전술 {

    static int V,E;

    static ArrayList<Integer>[] graph;
    static ArrayList<Integer>[] reverseGraph;

    static boolean[] visited;

    //1차 DFㄴ 종료 순서
    static ArrayList<Integer> order;

    //각 정점이 속한 SCC 번호
    static int[] sccId;

    //SCC별 정점 목록
    static ArrayList<ArrayList<Integer>> sccList;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V];
            reverseGraph = new ArrayList[V];

            for(int i=0;i<V;i++){
                graph[i] = new ArrayList<>();
                reverseGraph[i] = new ArrayList<>();
            }

            for(int i=0;i<E;i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);

                //간선 뒤집기
                reverseGraph[b].add(a);
            }

            visited = new boolean[V];
            order = new ArrayList<>();

            for(int i=0;i<V;i++){
                if(!visited[i]){
                    dfs1(i);
                }
            }

            Arrays.fill(visited, false);

            sccId = new int[V];
            Arrays.fill(sccId, -1);

            sccList = new ArrayList<>();

            int sccCount = 0;

            //1차 DFS 종료 순서의 역순
            for(int i=order.size()-1;i>=0;i--){
                int start =order.get(i);

                if(visited[start]){
                    continue;
                }

                ArrayList<Integer> scc = new ArrayList<>();

                dfs2(start, scc, sccCount);

                sccList.add(scc);

                sccCount++;

            }

            //SCC의 진입 차수 계싼
            int[] indegree = new int[sccCount];

            for(int cur =0;cur<V;cur++){
                for(int next : graph[cur]){
                    //서로 다른 SC 사이의 간섬나
                    if(sccId[cur] != sccId[next]){
                        indegree[sccId[next]]++;
                    }
                }
            }

            //진입 차수가 0인 SCC 찾기

            int zeroCount = 0;
            int answerScc = -1;

            for(int i=0;i < sccCount;i++){
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

                for(int vertex : answer){
                    sb.append(vertex).append("\n");
                }
            }

            sb.append("\n");

        }

        System.out.print(sb);
    }

    static void dfs1(int cur){
        visited[cur] = true;

        for(int next : graph[cur]){
            if(!visited[next]){
                dfs1(next);
            }
        }

        order.add(cur);

    }

    static void dfs2(int cur, ArrayList<Integer> scc, int id){
        visited[cur] = true;

        //cur이 몇번째 SCC인지 기록
        sccId[cur] = id;

        //현재 scc에 추가
        scc.add(cur);

        for(int next : reverseGraph[cur]){
            if(!visited[next]){
                dfs2(next, scc, id);
            }
        }
    }

}
