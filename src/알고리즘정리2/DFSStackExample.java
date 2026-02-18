package 알고리즘정리2;

import java.util.*;

/*
DFS (Depth
연결 요소 개수 구하기
섬의 개수
미로 탐색
DFS (스택) : 깊이 우선, 한경로 끝까지 탐색 후 되돌아옴
 */

public class DFSStackExample {
    public static void main(String[] args){
        //그래프 인접 리스트 표현
        int n = 5;  //노드 개수
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        //간선 추가 (무방향 그래프)
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);
        graph.get(3).add(5);

        boolean[] visited = new boolean[n+1];
        Stack<Integer> stack = new Stack<>();

        stack.push(1);  //시작 노드

        while(!stack.isEmpty()){
            int node = stack.pop();
            if(!visited[node]){
                visited[node] = true;
                System.out.println("DFS 방문 : "+ node);

                //인접 노드 push
                for(int next : graph.get(node)){
                    if(!visited[next]){
                        stack.push(next);
                    }
                }
            }
        }
    }
}
