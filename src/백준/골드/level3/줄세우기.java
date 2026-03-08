package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 줄세우기 {
    static int v,e;
    static int[] indegree;  //진입차수
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        //진입차수 : 들어오는 간선의 개수
        indegree = new int[v+1];
        Arrays.fill(indegree, 0);

        //그래프 초기화 1부터 하면 v개 되버리므로 0부터 하는게 맞음
        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<Integer>());
        }

        //간선 정보 입력
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //방향성이 있음
            graph.get(a).add(b);

            indegree[b] += 1;

        }

        topology_sort();



    }
    //위상정렬 정의
    public static void topology_sort(){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        //PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

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

        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i) + " ");
        }



    }

}
