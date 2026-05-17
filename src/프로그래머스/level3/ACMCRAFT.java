package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class ACMCRAFT {
    static int[] indegree;
    static int[] buildtime;
    static int[] acctime;
    static ArrayList<ArrayList<Integer>> edges;
    static int T, N, K, W;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());    //테스트 케이스
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   //건물 개수
            K = Integer.parseInt(st.nextToken());   //건선 순서 규칙

            edges = new ArrayList<>();
            indegree = new int[N+1];
            buildtime = new int[N+1];
            acctime = new int[N+1];

            st = new StringTokenizer(br.readLine());
            //각 건물 걸리는 시간
            for(int i=1;i<=N;i++){
                buildtime[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0;i<=N;i++){
                edges.add(new ArrayList<>());
            }

            //건물 사이의 규칙
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                edges.get(a).add(b);
                indegree[b] += 1;
            }

            W = Integer.parseInt(br.readLine());

            topology_sort();


            sb.append(acctime[W]).append("\n");

        }


        System.out.println(sb.toString());


    }

    static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            acctime[i] = buildtime[i];
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
                acctime[next] = Math.max(acctime[next], acctime[now] + buildtime[next]);
                indegree[next] -= 1;
                if(indegree[next] == 0){
                    q.offer(next);
                }

            }
        }

    }

}
