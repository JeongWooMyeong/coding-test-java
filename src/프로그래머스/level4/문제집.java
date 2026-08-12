package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 문제집 {

    static int N,M;
    static ArrayList<ArrayList<Integer>> edges;
    static int[] indegree;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        indegree = new int[N+1];
        result = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(b);

            indegree[b] += 1;
        }

        topology_sort();

        StringBuilder sb = new StringBuilder();
        for(int x : result){
            sb.append(x).append(" ");
        }

        System.out.println(sb.toString().trim());

    }

    static void topology_sort(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1;i<=N;i++){
            if(indegree[i] == 0){
                pq.offer(i);
            }
        }

        while(!pq.isEmpty()){
            int now = pq.poll();
            result.add(now);

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
                indegree[next] -= 1;
                if(indegree[next] == 0){
                    pq.offer(next);
                }
            }

        }

    }

}
