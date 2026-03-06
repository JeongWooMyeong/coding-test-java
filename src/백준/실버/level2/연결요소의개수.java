package 백준.실버.level2;

import java.util.*;

public class 연결요소의개수 {
    static int n, m;    //정점의 개수 n 간선의 개수 m
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n+1];

        //그래프 초기화
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int count = 0;
        for(int i=1;i<=n;i++){
            if(!visited[i]) {
                bfs(i);
                count++;
            }
        }
        //연결요소 개수 간선이랑 이어진 개수
        System.out.print(count);
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        //x에 대해서 방문처리
        visited[start] = true;

        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=0;i<graph.get(x).size();i++){
                int y = graph.get(x).get(i);
                if(!visited[y]){
                    q.offer(y);
                    //y에 대해서 방문처리
                    visited[y] = true;
                }
            }
        }
    }

}
