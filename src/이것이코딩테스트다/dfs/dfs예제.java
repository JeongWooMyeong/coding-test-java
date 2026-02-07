package 이것이코딩테스트다.dfs;

import java.util.*;

public class dfs예제 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    //DFS 함수
    public static void dfs(int x){
        visited[x] = true;
        System.out.println(x + " ");    //방문한 노드 출력

        //현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int i : graph.get(x)){
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //노드 개수
        int m = sc.nextInt(); // 간선 개수

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
            graph.get(b).add(a); //무방향 ㄱ래프
        }

        //dfs 실행 (1번 노드부터 시작)
        dfs(1);
    }
}
