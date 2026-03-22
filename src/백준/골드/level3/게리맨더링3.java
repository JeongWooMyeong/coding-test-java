package 백준.골드.level3;

import java.io.*;
import java.util.*;

public class 게리맨더링3 {
    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] population;
    static boolean[] selected;
    static int answer = Integer.MAX_VALUE;  //두 선걱구 인구 차이 최솟값

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        population = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }
        //2번째 줄 인구 입력
        for(int i=1;i<=N;i++){
            population[i] = Integer.parseInt(st.nextToken());
        }
        //인접한 도시 입력
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0;j<num;j++){
                int adjust = Integer.parseInt(st.nextToken());
                graph.get(i).add(adjust);
            }
        }

        selected = new boolean[N+1];

        dfs(1, selected);

        System.out.print(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    //그룹 나누기
    static void dfs(int idx, boolean[] selected){
        if(idx == N+1){
            List<Integer> groupA = new ArrayList<>();
            List<Integer> groupB = new ArrayList<>();

            for(int i=1;i<=N;i++){
                if(selected[i]) groupA.add(i);
                else groupB.add(i);
            }

            if(!groupA.isEmpty() && !groupB.isEmpty() && isConnected(groupA) && isConnected(groupB)){
                int sumA = 0;
                int sumB = 0;
                for(int a : groupA) sumA += population[a];
                for(int b : groupB) sumB += population[b];

                answer = Math.min(answer, Math.abs(sumB - sumA));
            }

            return;

        }

        selected[idx] = true;
        dfs(idx + 1, selected);

        selected[idx] = false;
        dfs(idx + 1, selected);

    }

    static boolean isConnected(List<Integer> group){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(group.get(0));
        boolean[] visited = new boolean[N+1];
        visited[group.get(0)] = true;
        int count = 1;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<graph.get(now).size();i++){
                int next = graph.get(now).get(i);
                if(!visited[next] && group.contains(next)){
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }
        }

        return group.size() == count;

    }

}
