package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class ACMCRAFT3 {
    static int T, N, K, W;
    //테스트 케이스 있을때는 여기다 선언하면 안됌..
    //static List<ArrayList<Integer>> graph = new ArrayList<>();
    static List<ArrayList<Integer>> graph;
    static int[] indegree;
    static int[] buildTime;
    static int[] accTime;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //테스트 케이스
        T = Integer.parseInt(st.nextToken());

        while(T-- > 0){
            graph = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   //건물의 개수
            K = Integer.parseInt(st.nextToken());   //건설순서 총 개수 K

            indegree = new int[N+1];
            buildTime = new int[N+1];
            accTime = new int[N+1];

            for(int i=0;i<=N;i++){
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());

            for(int i=1;i<=N;i++){
                buildTime[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                //진입차수 1 증가
                indegree[b] += 1;
            }
            //위상정렬 시행
            topology_sort();

            W = Integer.parseInt(br.readLine());

           sb.append(accTime[W]).append("\n");;

        }

        System.out.print(sb.toString());
    }

    static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();

        //진입 차수 0인 인덱스 담기
        for(int i=1;i<=N;i++){
            accTime[i] = buildTime[i];
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<graph.get(now).size();i++){
                int next = graph.get(now).get(i);
                accTime[next] = Math.max(accTime[next], accTime[now] + buildTime[next]);
                indegree[next]--;
                if(indegree[next] == 0) q.add(next);
            }
        }

    }

}
