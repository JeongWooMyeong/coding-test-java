package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class ACMCRAFT4 {

    static int T;
    static int N,K,W;
    static int[] buildtime;
    static int[] dptime;
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> edges;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();
            for(int i=0;i<=N;i++) edges.add(new ArrayList<>());
            dptime = new int[N+1];
            buildtime = new int[N+1];
            indegree = new int[N+1];

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

            W = Integer.parseInt(br.readLine());

            topology_sort();
            sb.append(dptime[W]).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void topology_sort(){
        Deque<Integer> q = new ArrayDeque<>();

        for(int i=1;i<=N;i++){
            if(indegree[i] == 0){
                q.addFirst(i);
                dptime[i] = buildtime[i];
            }
        }

        while(!q.isEmpty()){
            int now = q.pollFirst();

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
                indegree[next] -= 1;
                dptime[next] = Math.max(dptime[next], dptime[now] + buildtime[next]);

                if(indegree[next] == 0){
                    q.addFirst(next);
                }

            }
        }

    }

}
