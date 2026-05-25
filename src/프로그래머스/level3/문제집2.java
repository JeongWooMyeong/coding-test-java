package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 문제집2 {
    static ArrayList<ArrayList<Edge>> edges;
    static int[] indegree;
    static ArrayList<Integer> resultList;
    static int n,m;

    static class Edge implements Comparable<Edge>{
        int to;
        //int idx;

        public Edge(int to){
            this.to = to;
            //this.idx = idx;
        }

        public int compareTo(Edge other){
            return this.to - other.to;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        indegree = new int[n+1];
        edges = new ArrayList<>();
        resultList = new ArrayList<>();

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b));
            indegree[b] += 1;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=1;i<=n;i++){
            if(indegree[i] == 0){
                pq.offer(new Edge(i));
            }
        }

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            resultList.add(now);
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                indegree[next] -= 1;
                if(indegree[next] == 0){
                    pq.offer(new Edge(next));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int x : resultList){
            sb.append(x).append(" ");
        }

        System.out.println(sb.toString());

    }

}
