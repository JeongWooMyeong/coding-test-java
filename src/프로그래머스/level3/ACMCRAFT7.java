package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class ACMCRAFT7 {

    static int T,N,K,W;
    static int[] buildtime;
    static int[] dptime;
    static List<List<Integer>> edges;
    static int[] indegree;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            indegree = new int[N+1];
            edges = new ArrayList<>();
            for(int i=0;i<=N;i++) edges.add(new ArrayList<>());

            buildtime = new int[N+1];
            dptime = new int[N+1];

            st = new StringTokenizer(br.readLine());

            for(int i=1;i<=N;i++){
                buildtime[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                edges.get(a).add(b);
                indegree[b] += 1;
            }

            topology_sort();

            W = Integer.parseInt(br.readLine());

            sb.append(dptime[W]).append("\n");

        }

        System.out.println(sb);
    }

    static void topology_sort(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1;i<=N;i++){
            if(indegree[i] == 0){
                pq.offer(i);
                dptime[i] = buildtime[i];
            }
        }

        while(!pq.isEmpty()){
            int now = pq.poll();

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
                dptime[next] = Math.max(dptime[next], dptime[now] + buildtime[next]);
                indegree[next] -= 1;

                if(indegree[next] == 0){
                    pq.offer(next);
                }

            }

        }

    }

}
