package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 음악프로그램2 {

    static int N,M;
    static List<List<Integer>> edges;
    static int[] indegree;
    static List<Integer> result;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        indegree = new int[N+1];

        for(int i=0;i<=N;i++) edges.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int cur = Integer.parseInt(st.nextToken());
            for(int j=0;j<num-1;j++){
                int next = Integer.parseInt(st.nextToken());
                edges.get(cur).add(next);
                indegree[next] += 1;
                cur = next;
            }
        }

        sb = new StringBuilder();
        result = new ArrayList<>();

        topology_sort();

        if(result.size() != N){
            System.out.println(0);
            return;
        }

        for(int x : result){
            sb.append(x).append("\n");
        }

        System.out.println(sb);
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
            result.add(now);

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
