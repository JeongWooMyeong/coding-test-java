package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 음악프로그램 {
    static int v, e;
    static int[] indegree;
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
            int cnt = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for(int j=1;j<cnt;j++){
                int next = Integer.parseInt(st.nextToken());
                graph.get(prev).add(next);
                indegree[next] += 1;
                //갱신 필요하구나..
                prev = next;
            }
        }

        topology_sort();

    }

    public static void topology_sort(){
        ArrayList<Integer> result = new ArrayList<>();  //결과 담을
        Queue<Integer> q = new LinkedList<>();

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

        //사이클 존재 여부 확인
        if(result.size() != v){
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i : result){
            sb.append(i).append("\n");
        }

        System.out.print(sb);

    }

}
