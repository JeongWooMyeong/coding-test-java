package 백준.플레티넘.level5;

import java.util.*;
import java.io.*;

public class 임계경로 {
    static int n, m; //도시의 개수 n, 월드 나라의 도로의 개수 m
    static ArrayList<ArrayList<City>> edges = new ArrayList<>();
    static ArrayList<ArrayList<City>> reverse = new ArrayList<>();
    static int[] dist;
    static int[] indegree;

    static class City{
        private int b;
        private int cost;

        public City(int b, int cost){
            this.b = b;
            this.cost = cost;

        }

        public int getB(){
            return this.b;
        }

        public int getCost(){
            return this.cost;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n+1];
        indegree = new int[n+1];

        Arrays.fill(indegree, 0);

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }


        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new City(b, cost));
            reverse.get(b).add(new City(a, cost));
            indegree[b] += 1;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        topology_sort();

        //위상정렬에서 구한 dist 배열 값 가지고 역추적
        int cnt = reverseTrace(end);

        System.out.println(dist[end]);
        System.out.println(cnt);


    }

    static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        dist = new int[n+1];
        for(int i=1;i<=n;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).getB();
                int cost = edges.get(now).get(i).getCost();
                if(dist[next] < dist[now] + cost){
                    dist[next] = dist[now] + cost;
                }
                indegree[next] -= 1;
                if(indegree[next] == 0){
                    q.offer(next);
                }

            }
        }

    }

    static int reverseTrace(int end){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        int count = 0;

        q.offer(end);
        visited[end] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<reverse.get(now).size();i++){
                int prev = reverse.get(now).get(i).getB();
                int cost = reverse.get(now).get(i).getCost();
                if(dist[now] == dist[prev] + cost){
                    count++;
                    if(!visited[prev]) {
                        visited[prev] = true;
                        q.offer(prev);
                    }
                }
            }
        }

        return count;


    }

}
