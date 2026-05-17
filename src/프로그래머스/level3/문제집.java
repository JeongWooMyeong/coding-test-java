package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 문제집 {
    static int N, M;
    static ArrayList<ArrayList<Problem>> edges;
    static int[] indegree;
    static ArrayList<Integer> resultList;

    static class Problem implements Comparable<Problem>{
        int to;

        public Problem(int to){
            this.to = to;
        }

        public int compareTo(Problem other){
            return this.to - other.to;
        }

    }

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
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Problem(b));
            indegree[b] += 1;
        }

        resultList = new ArrayList<>();

        topology_sort();

        StringBuilder sb = new StringBuilder();

        for(int x : resultList){
            sb.append(x).append(" ");
        }

        System.out.println(sb.toString());


    }

    static void topology_sort(){
        PriorityQueue<Problem> pq = new PriorityQueue<>();
        for(int i=1;i<=N;i++){
            if(indegree[i] == 0 ){
                pq.offer(new Problem(i));
            }
        }

        while(!pq.isEmpty()){
            Problem cur = pq.poll();
            int now = cur.to;
            resultList.add(now);
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                indegree[next] -= 1;
                if(indegree[next] == 0){
                    pq.offer(new Problem(next));
                }
            }
        }

    }

}
