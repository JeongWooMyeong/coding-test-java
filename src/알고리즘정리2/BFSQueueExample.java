package 알고리즘정리2;


/*
최단 거리 탐색 (미로탐색)
숨바꼭질 (BFS로 최소 이동 횟수 찾기)
토마토문제 (BFS로 익는 시간)
BFS(큐) : 너비 우선 -> 가까운노드부터 차례대로 탐색
최단 거리 문제에 적합
 */
import java.util.*;

public class BFSQueueExample {
    public static void main(String[] args){
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
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);//시작노드
        visited[1] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.println("BFS 방문 : " + node);

            for(int next : graph.get(node)){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
