package 백준.플레티넘.level5;

import java.util.*;
import java.io.*;

public class 임계경로3 {
    static int n,m;
    static ArrayList<ArrayList<City>> edges = new ArrayList<>();
    static ArrayList<ArrayList<City>> reversed = new ArrayList<>();

    static int[] dist;
    static int[] indegree;

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

        dist = new int[n+1];
        indegree = new int[n+1];

        //진입차수 0으로 초기화
        Arrays.fill(indegree, 0);

        //도시 간선 정보 리스트 초기화
        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
            reversed.add(new ArrayList<>());
        }

        //도로의 정보
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new City(b,cost));
            reversed.get(b).add(new City(a, cost));
        }
        //시작 종료점 입력
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        //위상정렬 시행
        topology_sort();

        //선택받은 사람들이 모두 로마에 도착하는데 걸리는 시간
        System.out.println(dist[end]);
        //황금을 칠해야할 도로의 수 -> 역추적 필요
        System.out.println(reversedTrace(end));

    }

    static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            //진입차수 0인 인덱스 q에 넣기
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
    //역추적 마지막부터 시작
    static int reversedTrace(int end){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(end);
        visited[end] = true;
        int count = 0;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<reversed.get(now).size();i++){
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
