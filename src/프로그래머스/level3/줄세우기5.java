package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 줄세우기5 {
    static int N,M;
    static ArrayList<ArrayList<Integer>> edges;
    static int[] indegree;
    static ArrayList<Integer> resultList;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        indegree = new int[N+1];
        resultList = new ArrayList<>();

        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(b);
            indegree[b] += 1;
        }

        topology_sort();

        StringBuilder sb = new StringBuilder();
        for(int x : resultList){
            sb.append(x).append(" ");
        }

        System.out.println(sb.toString());

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
