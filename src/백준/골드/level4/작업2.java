package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 작업2 {
    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] buildTime;
    static int[] accTime;
    static int[] indegree;
    static StringBuilder sb = new StringBuilder();
    static int K;   //선행되어야할 작업 개수

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        buildTime = new int[N+1];
        accTime = new int[N+1];
        indegree = new int[N+1];

        //그래프 초기화
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            for(int j=0;j<K;j++){
                int pre = Integer.parseInt(st.nextToken());
                //선행되어야할 작업
                graph.get(pre).add(i);

                indegree[i] += 1;
            }
        }
        //위상 정렬 시행
        topology_sort();
        //이렇게 하면 마지막 누적시간만 나오므로 전체작업중 가장 오래걸린 시간 출력해야함
        //System.out.print(accTime[N]);
        int result = Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            result = Math.max(result, accTime[i]);
        }

        System.out.print(result);

    }

    static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            accTime[i] = buildTime[i];
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<graph.get(now).size();i++){
                int next = graph.get(now).get(i);
                accTime[next] = Math.max(accTime[next], accTime[now] + buildTime[next]);
                indegree[next]--;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }
    }
}
