package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 작업3 {

    static ArrayList<ArrayList<Integer>> edges;
    static int[] indegree;
    static int N;
    static int[] buildtime;
    static int[] dptime;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        indegree = new int[N+1];
        buildtime= new int[N+1];
        dptime = new int[N+1];
        edges = new ArrayList<>();
        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            buildtime[i] = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0;j<num;j++){
                int next = Integer.parseInt(st.nextToken());
                edges.get(next).add(i);
                indegree[i] += 1;
            }
        }

        topology_sort();

        int answer = Integer.MIN_VALUE;

        for(int i=1;i<=N;i++){
            answer = Math.max(answer, dptime[i]);
        }

        System.out.println(answer);


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
