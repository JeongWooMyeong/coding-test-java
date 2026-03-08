package 백준.골드.level2;

import java.util.*;
import java.io.*;

public class 문제집 {
    static int v, e;
    static int[] indegree;  //진입차수
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        indegree = new int[v+1];
        Arrays.fill(indegree, 0);

        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);

            indegree[b] += 1;

        }

        topology_sort();


    }

    public static void topology_sort(){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=1;i<=v;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            result.add(now);
            for(int i=0;i<graph.get(now).size();i++){
                indegree[graph.get(now).get(i)] -= 1;
                if(indegree[graph.get(now).get(i)] == 0){
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        //사이클 검증도 필요 (만약 모든 노드 출력 못하면 사이클 발생)
        if(result.size() != v){
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i : result){
            sb.append(i).append(" ");
        }

        System.out.print(sb.toString().trim());

    }

}
