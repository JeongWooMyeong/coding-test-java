package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 줄세우기2 {
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] indegree;  //진입 차수


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
       
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        indegree = new int[N+1];

        Arrays.fill(indegree, 0);

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            indegree[b] += 1;
        }

        topology_sort();    //위상정렬 - 순서가 있는 학생 A가 B의 앞에 서야 한다

    }

    static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        //1부터 시작
        for(int i=1;i<=N;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            result.add(now);

            for(int i=0;i<graph.get(now).size();i++){
                int next = graph.get(now).get(i);
                indegree[next] -= 1;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }

        }

        for(int x : result){
            System.out.print(x + " ");
        }

    }
}
