package 백준.골드.level3;

import java.io.*;
import java.util.*;

public class 게리맨더링 {
    static int N;
    static int[] population;    //구역의 개수
    static List<Integer>[] adj;
    static int answer = Integer.MAX_VALUE;  //최소 인구 차이 저장

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

        //인접 구역 정보 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken()); //인접 구역 개수
            for(int j=0;j<cnt;j++){
                int neighbor = Integer.parseInt(st.nextToken()) -1; //0-index
                adj[i].add(neighbor);
            }
        }

        //부분집합을 이용해 두 그룹으로 나누기
        //mask는 1부터 (1<<N)-2까지 (즉 공집합과 전체집합 제외)
        for(int mask=1;mask < (1<<N)-1;mask++){
            List<Integer> groupA = new ArrayList<>();
            List<Integer> groupB = new ArrayList<>();

            //비트마스크로 그룹 나누기
            for(int i=0;i<N;i++){
                if((mask & (1 << i)) != 0) groupA.add(i);
                else groupB.add(i);
            }

            //두 그룹 모두 연결되어 있는지 확인
            if(isConnected(groupA) && isConnected(groupB)){
                int sumA = 0, sumB = 0;
                for(int a : groupA) sumA += population[a];
                for(int b : groupB) sumB += population[b];
                answer = Math.min(answer, Math.abs(sumA - sumB));
            }
        }

        //결과 출력
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    //BFS로 연결성 확인
    static boolean isConnected(List<Integer> group){
        if(group.isEmpty()) return false;

        boolean[] visited = new boolean[N];
        Queue<Integer> q = new ArrayDeque<>();

        //시작점은 그룹의 첫번째 구역
        q.add(group.get(0));
        visited[group.get(0)] = true;

        int count = 1;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : adj[cur]){
                //같은 그룹에 속하고 아직 방문하지 않았다면
                if(!visited[next] && group.contains(next)){
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
        }

        //그룹 내 모든 구역을 방문했는지 확인
        return count == group.size();
    }
}
