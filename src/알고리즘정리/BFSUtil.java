package 알고리즘정리;

import java.util.*;

public class BFSUtil {
    public static void bfs(int start, boolean[] visited, List<List<Integer>> graph){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int next : graph.get(node)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }

}
