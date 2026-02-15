package 알고리즘정리;

import java.util.*;

public class DFSUtil {
    public static void dfs(int node, boolean[] visited, List<List<Integer>> graph){
        visited[node] =true;
        for(int next : graph.get(node)){
            if(!visited[next]){
                dfs(next, visited, graph);
            }
        }
    }
}
