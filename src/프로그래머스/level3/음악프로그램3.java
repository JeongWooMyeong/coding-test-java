package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 음악프로그램3 {

    static int N,M;
    static List<Integer> result;
    static int[] indegree;
    static List<List<Integer>> edges;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new ArrayList<>();
        indegree = new int[N+1];
        edges = new ArrayList<>();
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

        topology_sort();

        StringBuilder sb = new StringBuilder();

        if(result.size() == N){
            for(int x : result){
                sb.append(x).append("\n");
            }
        }else{
            sb.append("0");
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

        while (!q.isEmpty()) {
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
