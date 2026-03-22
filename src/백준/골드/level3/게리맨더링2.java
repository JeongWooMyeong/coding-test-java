package 백준.골드.level3;

import java.io.*;
import java.util.*;

public class 게리맨더링2 {
    static int N;
    static int[] population;
    static List<Integer>[] adj;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        population = new int[N];
        adj = new ArrayList[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            population[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for(int j=0;j<cnt;j++){
                int neighbor = Integer.parseInt(st.nextToken()) - 1;
                adj[i].add(neighbor);
            }
        }

        //DFS로 그룹 나누기 시작
        boolean[] selected = new boolean[N];
        dfs(0, selected);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    //i번째 구역을 A에 넣을지 B에 넣을지 결정
    static void dfs(int idx, boolean[] selected){
        if(idx == N){
            List<Integer> groupA = new ArrayList<>();
            List<Integer> groupB = new ArrayList<>();
            for(int i=0;i<N;i++){
                if(selected[i]) groupA.add(i);
                else groupB.add(i);
            }

            //두 그룹이 모두 비어있지 않고 연결되어[ 있는지 확인
            if(!groupA.isEmpty() && !groupB.isEmpty() && isConnected(groupA) && isConnected(groupB)){
                int sumA = 0, sumB = 0;
                for(int a : groupA) sumA += population[a];
                for(int b : groupB) sumB += population[b];
                answer = Math.min(answer, Math.abs(sumA - sumB));
            }
            return;
        }

        //idx 구역을 A에 넣기
        selected[idx] = true;
        dfs(idx + 1, selected);

        //idx 구역을 B에 넣기
        selected[idx] = false;
        dfs(idx + 1, selected);
    }

    //BFS로 연결성 확인
    static boolean isConnected(List<Integer> group){
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(group.get(0));
        visited[group.get(0)] = true;
        int count = 1;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : adj[cur]){
                if(!visited[next] && group.contains(next)){
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
        }
        return count == group.size();
    }

}
