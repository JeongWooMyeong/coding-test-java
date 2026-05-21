package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 최종순위 {
    static ArrayList<ArrayList<Integer>> edges;
    static int[] indegree;
    static int[] lastRank;
    static int T, n, m;
    static List<Integer> resultList;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        while(T-- > 0) {
            edges = new ArrayList<>();
            n = Integer.parseInt(br.readLine());
            lastRank = new int[n];
            indegree = new int[n+1];
            resultList = new ArrayList<>();

            for(int i=0;i<=n;i++){
                edges.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                lastRank[i] = Integer.parseInt(st.nextToken());
            }
            //간선 정보 입력
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int a = lastRank[i];
                    int b = lastRank[j];
                    edges.get(a).add(b);
                    indegree[b] += 1;
                }
            }

            //바뀐 정보 변경
            m = Integer.parseInt(br.readLine());
            for(int i=0;i<m;i++){
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

    static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        boolean cycle = false;
        boolean certain = true;

        for(int i=1;i<=n;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            if(q.size() > 1){
                certain = false;
            }
            int now = q.poll();
            resultList.add(now);
            for(int i=0;i<edges.get(now).size();i++){
                int next =edges.get(now).get(i);
                indegree[next] -= 1;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }

        }

        if(resultList.size() != n) cycle = true;


        if(cycle){
            sb.append("IMPOSSIBLE").append("\n");
        }else if(!certain){
            sb.append("?").append("\n");
        }else{
            for(int x : resultList) sb.append(x).append(" ");
            sb.append("\n");
        }
    }

}
