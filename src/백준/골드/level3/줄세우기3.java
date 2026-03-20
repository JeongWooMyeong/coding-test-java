package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 줄세우기3 {
    static int N, M;    //학생수 N, 키 비교 M
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    static int[] indegree;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        indegree = new int[N+1];
        Arrays.fill(indegree, 0);   //진입 차수 0 초기화

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(b);
            indegree[b] += 1;
        }

        topology_sort();


    }

    static void topology_sort(){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

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
                indegree[next] -= 1;   //진입 차수 1 빼기 (연결되어 있는)
                if(indegree[next] == 0) {
                    //진입 차수 0ㅇㄴ건 큐에 넣기
                    q.offer(next);
                }
            }
        }

        for(int x : result){
            System.out.print(x + " ");
        }
    }
}
