package 프로그래머스.level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게임개발3 {

    static int N;
    static ArrayList<ArrayList<Integer>> edges;
    static int[] indegree;
    static int[] dptime;
    static int[] buildtime;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        indegree = new int[N+1];
        dptime = new int[N+1];
        buildtime = new int[N+1];
        edges = new ArrayList<>();
        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            buildtime[i] = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            while(value != -1){
                edges.get(value).add(i);
                indegree[i] += 1;
                value = Integer.parseInt(st.nextToken());
            }

        }

        topology_sort();

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++){
            sb.append(dptime[i]).append("\n");
        }

        System.out.println(sb.toString());
     }

     static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            dptime[i] = buildtime[i];
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
                dptime[next] = Math.max(dptime[next], dptime[now] + buildtime[next]);
                indegree[next] -= 1;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

     }

}
