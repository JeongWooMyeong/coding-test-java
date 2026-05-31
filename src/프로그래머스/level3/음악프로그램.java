package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 음악프로그램 {

    static int N, M;
    static ArrayList<ArrayList<Integer>> edges;
    static int[] indegree;
    static ArrayList<Integer> resultList;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        edges = new ArrayList<>();
        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int cur = Integer.parseInt(st.nextToken());
            for(int idx=0;idx<p-1;idx++){
                int next = Integer.parseInt(st.nextToken());
                edges.get(cur).add(next);
                indegree[next] += 1;
                cur = next;
            }
        }

        resultList = new ArrayList<>();

        topology_sort();

        if(resultList.size() != N){
            System.out.println("0");
        }else {

            StringBuilder sb = new StringBuilder();
            for (int x : resultList) {
                sb.append(x).append("\n");
            }

            System.out.println(sb.toString());
        }


    }

    static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            resultList.add(now);
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
                indegree[next] -= 1;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

    }

}
