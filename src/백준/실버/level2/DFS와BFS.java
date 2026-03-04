package 백준.실버.level2;

import java.util.*;

public class DFS와BFS {
    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    //DFS 함수 정의
    public static void dfs(int x){
        //현재 노드를 방문 처리
        visited[x] = true;
        System.out.print(x + " ");
        //현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for(int i=0;i<graph.get(x).size();i++){
            int y = graph.get(x).get(i);
            if(!visited[y]) dfs(y);
        }
    }
    
    //BFS 함수 정의
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        //현재 노드를 방문 처리
        visited[start] = true;
        //큐가 빌때까지 반복
        while(!q.isEmpty()){
            //큐에서 원소를 하나 뽑아 출력
            int x = q.poll();
            System.out.print(x + " ");
            //해당 원소와 연결된 아직 방문하지 않은 원소들을 큐에 삽입
            for(int i=0;i<graph.get(x).size();i++){
                int y = graph.get(x).get(i);
                if(!visited[y]){
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<Integer>());
        }

        //그래프 초기화 (양방향)
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //정점 번호가 작은 것부터 방문하도록 정렬
        for(int i=1;i<=n;i++){
            Collections.sort(graph.get(i));
        }

        dfs(start);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(start);

    }


}
