package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 게임개발5 {

    static int N;
    static int[] buildtime;
    static int[] dptime;
    static StringBuilder sb;
    static int[] indegree;
    static List<List<Integer>> edges;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        buildtime = new int[N+1];
        dptime = new int[N+1];
        indegree = new int[N+1];
        sb = new StringBuilder();
        edges = new ArrayList<>();
        for(int i=0;i<=N;i++) edges.add(new ArrayList<>());

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            buildtime[i] = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());

            while(prev != -1){
                edges.get(prev).add(i);
                indegree[i] += 1;
                prev = Integer.parseInt(st.nextToken());
            }
        }

        topology_sort();

        sb = new StringBuilder();

        for(int i=1;i<=N;i++){
            sb.append(dptime[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(indegree[i] == 0){
                q.offer(i);
                dptime[i] = buildtime[i];
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
                dptime[next] = Math.max(dptime[next], dptime[now] + buildtime[next]);
                indegree[next] -= 1;

                if(indegree[next] == 0){
                    q.offer(next);
                }

            }

        }

    }

}
