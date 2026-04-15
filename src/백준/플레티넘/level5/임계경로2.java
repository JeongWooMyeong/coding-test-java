package 백준.플레티넘.level5;

import java.util.*;
import java.io.*;

public class 임계경로2 {
    static int n, m;
    static ArrayList<ArrayList<City>> edges = new ArrayList<>();
    static ArrayList<ArrayList<City>> reversed = new ArrayList<>();
    static int[] indegree;
    static int[] dist;

    static class City{
        int next;
        int cost;
        public City(int next, int cost){
            this.next = next;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        indegree = new int[n+1];
        dist = new int[n+1];

        Arrays.fill(indegree, 0);

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
            reversed.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new City(b,cost));
            reversed.get(b).add(new City(a,cost));  //역추적
            indegree[b] += 1;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        topology_sort();

        int cnt = reversedTrace(end);


        System.out.println(dist[end]);
        System.out.println(cnt);


    }

    static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).next;
                int cost = dist[now] + edges.get(now).get(i).cost;
                if(dist[next] < cost){
                    dist[next] = cost;
                }
                indegree[next] -= 1;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

    }

    static int reversedTrace(int end){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        int count = 0;
        q.offer(end);
        visited[end] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<reversed.get(now).size();i++){
                /*
                사실 역추적에서는 정방향에서 갱신했던 관계를 그대로 확인해야 합니다.
                 */
                int prev = reversed.get(now).get(i).next;
                int cost = dist[prev] + reversed.get(now).get(i).cost;
                if(dist[now] == cost){
                    count++;
                    if(!visited[prev]){
                        visited[prev] = true;
                        q.offer(prev);
                    }
                }
            }
        }
        return count;
    }

}
