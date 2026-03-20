package 백준.골드.level2;

import java.util.*;
import java.io.*;

public class 문제집2 {
    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    static int[] indegree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        indegree = new int[N+1];
        Arrays.fill(indegree, 0);

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(b);
            indegree[b] += 1;

        }

        topology_sort();

        System.out.print(sb);

    }

    static void topology_sort(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=1;i<=N;i++){
            if(indegree[i] == 0){
                pq.offer(i);
            }
        }

        while(!pq.isEmpty()){
            int now = pq.poll();
            result.add(now);

            for(int i=0;i<edges.get(now).size();i++){
                int next= edges.get(now).get(i);
                indegree[next] -= 1;
                if(indegree[next] == 0){
                    pq.offer(next);
                }
            }
        }


        for(int x : result){
            sb.append(x).append(" ");

            //System.out.print(x + " ");
        }

    }


}
