package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 음악프로그램2 {
    static int N,M;
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    static int[] indegree;
    static int INF = (int) 1e9;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree =new int[N+1];
        Arrays.fill(indegree, 0);

        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for(int j=1;j<cnt;j++){
                int next = Integer.parseInt(st.nextToken());
                edges.get(prev).add(next);
                indegree[next] += 1;
                prev = next;
            }
        }

        topology_sort();

    }

    static void topology_sort(){
        List<Integer> result = new ArrayList<>();   //결과 담음 리스트
        Queue<Integer> q = new LinkedList<>();
        //Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
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
                indegree[next]--;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        if(result.size() != N){
            System.out.println(0);
            return;
        }

        for(int x : result){
            System.out.println(x);
        }


    }

}
