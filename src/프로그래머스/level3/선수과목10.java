package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 선수과목10 {

    static int N,M;
    static int[] indegree;
    static int[] semester;
    static List<List<Integer>> edges;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        semester = new int[N+1];
        edges = new ArrayList<>();
        for(int i=0;i<=N;i++) edges.add(new ArrayList<>());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            indegree[b] += 1;
            edges.get(a).add(b);
        }


        topology_sort();

        sb = new StringBuilder();

        for(int i=1;i<=N;i++){
            sb.append(semester[i]).append(" ");
        }

        System.out.println(sb);

    }

    static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(indegree[i] == 0){
                semester[i] = 1;
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
                semester[next] = Math.max(semester[next], semester[now] + 1);
                indegree[next]--;

                if(indegree[next] == 0){
                    q.offer(next);
                }



            }

        }

    }

}
