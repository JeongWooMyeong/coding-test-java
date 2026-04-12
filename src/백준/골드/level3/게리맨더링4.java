package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 게리맨더링4 {
    static int N;
    //인접한 선거구 관련
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    //선거구 인구
    static int[] arr;
    static boolean[] selected;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=0;i<=N;i++){
            adj.add(new ArrayList<>());
        }
        //1~N번 선거구 간선 정보 입력
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            for(int j=0;j<cnt;j++){
                int v = Integer.parseInt(st.nextToken());
                adj.get(i).add(v);
            }

        }

        selected = new boolean[N+1];

        dfs(1);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

    }

    static void dfs(int idx){
        if(idx == N+1){
            List<Integer> groupA = new ArrayList<>();
            List<Integer> groupB = new ArrayList<>();
            //selected 된건 groupA, 아니면 groupb
            for(int i=1;i<=N;i++){
                if(selected[i]) groupA.add(i);
                else groupB.add(i);
            }
            //경우의 수에 따라 A가 비거나 B가 비는 경우 있을 수 있음 (몰아주기)
            if(groupA.size() == 0 || groupB.size() == 0) return;
            //그룹 A와 그룹 B가 정상적으로 이어져 있으면
            if(isConnected(groupA) && isConnected(groupB)){
                int sumA = 0;
                int sumB = 0;
                for(int a : groupA) sumA += arr[a];
                for(int b : groupB) sumB += arr[b];
                result= Math.min(result, Math.abs(sumA-sumB));
            }

            return;
        }
        //현재 그룹을 선택한다
        selected[idx] = true;
        dfs(idx+1);

        //현재 그룹을 선택하지 않는다
        selected[idx] = false;
        dfs(idx+1);

    }

    static boolean isConnected(List<Integer> group){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited= new boolean[N+1];
        q.offer(group.get(0));
        visited[group.get(0)] = true;
        int count = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0;i<adj.get(cur).size();i++){
                int next = adj.get(cur).get(i);
                if(!visited[next] && group.contains(next)){
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }

            }
        }

        return count == group.size();
    }

}
