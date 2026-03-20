package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class ACMCRAFT2 {
    static int T, N, K, W;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] arrtime;
    static int[] indegree;  //진입차수 1번 건물의 건설이 완료된다면 2번과 3번 건설 시작

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int k=0;k<T;k++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            arrtime = new int[N+1];
            indegree = new int[N+1];
            Arrays.fill(indegree, 0);
            //그래프 초기화
            for(int i=0;i<=N;i++){
                graph.add(new ArrayList<>());
            }

            //시간 입력
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++){
                arrtime[i] = Integer.parseInt(st.nextToken());
            }

            //건설 순서 입력
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                indegree[b] += 1;
            }

            //건물 W를 건설 완료
            W = Integer.parseInt(br.readLine());

            topology_sort();
        }

    }

    static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        int[] dp = new int[N+1];    //각 건물짓는데 최소시간
        for(int i=1;i<=N;i++){
            dp[i] = arrtime[i];
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<graph.get(now).size();i++){
                int next = graph.get(now).get(i);
                dp[next] = Math.max(dp[next], dp[now] + arrtime[next]);
                indegree[next] -= 1;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }

        }

        System.out.println(dp[W]);
    }

}
