package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 최종순위3 {

    static int T, N, M;
    static ArrayList<ArrayList<Integer>> edges;
    static int[] indegree;
    static int[] group;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> resultList;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            resultList = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            group = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++){
                group[i] =  Integer.parseInt(st.nextToken());
            }

            edges = new ArrayList<>();
            for(int i=0;i<=N;i++){
                edges.add(new ArrayList<>());
            }

            indegree = new int[N+1];

            for(int i=1;i<=N;i++){
                for(int j=i+1;j<=N;j++){
                    int a = group[i];
                    int b = group[j];

                    edges.get(a).add(b);
                    indegree[b] += 1;
                }
            }

            M = Integer.parseInt(br.readLine());

            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(edges.get(a).contains(b)){
                    edges.get(a).remove(Integer.valueOf(b));
                    indegree[b] -= 1;
                    edges.get(b).add(a);
                    indegree[a] += 1;
                }else{
                    edges.get(b).remove(Integer.valueOf(a));
                    indegree[a] -= 1;
                    edges.get(a).add(b);
                    indegree[b] += 1;
                }

            }

            topology_sort();

        }

        System.out.println(sb.toString());

    }

    static void topology_sort() {
        Queue<Integer> q = new LinkedList<>();
        boolean cycle = false;
        boolean certain = true;
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            if (q.size() > 1) certain = false;
            int now = q.poll();
            resultList.add(now);

            for (int i = 0; i < edges.get(now).size(); i++) {
                int next = edges.get(now).get(i);
                indegree[next] -= 1;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }


        }

        if (resultList.size() != N) {
            sb.append("IMPOSSIBLE").append("\n");
        } else if (!certain) {
            sb.append("?").append("\n");
        } else {
            for(int x : resultList){
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }
    }

}
