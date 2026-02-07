package 이것이코딩테스트다.bfs;

import java.util.*;

public class bfs예제 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    //BFS 함수
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while(!q.isEmpty()){
            int x = q.poll();
            System.out.println(x + " "); //방문한 노드 출력

            for(int i : graph.get(x)){
                if(!visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //노드 개수
        int m = sc.nextInt(); //간선 개수

        visited = new boolean[n+1];

        //그래프 초기화
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        //간선 입력
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //BFS 실행 (1번 노드부터 시작)
        bfs(1);

    }
}
