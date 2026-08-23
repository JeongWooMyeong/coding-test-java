package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 동굴탐험14 {

    static int[] before;
    static int[] after;
    static ArrayList<ArrayList<Integer>> edges;
    static boolean[] visited;
    static boolean answer;
    static int n1;

    public static boolean solution(int n, int[][] path, int[][] order){

        n1 = n;
        edges = new ArrayList<>();
        for(int i=0;i<n;i++){
            edges.add(new ArrayList<>());
        }

        for(int[] p : path){
            int a = p[0];
            int b = p[1];

            edges.get(a).add(b);
            edges.get(b).add(a);

        }

        before = new int[n];
        after = new int[n];

        Arrays.fill(before, -1);
        Arrays.fill(after, -1);

        for(int[] o : order){
            before[o[1]] = o[0];
        }

        if(before[0] != -1) return false;

        answer = false;
        answer = bfs(0);

        return answer;

    }

    static boolean bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n1];
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(after[cur] != -1){
                int unlocked = after[cur];
                if(!visited[unlocked]){
                    visited[unlocked] = true;
                    q.offer(unlocked);
                }
            }

            for(int i=0;i<edges.get(cur).size();i++){
                int next = edges.get(cur).get(i);

                if(visited[next]) continue;

                if(before[next] != -1 && !visited[before[next]]){
                    after[before[next]] =next;
                    continue;
                }

                visited[next] = true;
                q.offer(next);

            }

        }

        for(boolean v : visited){
            if(!v) return false;
        }

        return true;

    }

    public static void main(String[] args) throws Exception{
        int n = 9;
        int[][] path = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] order = {{8,5},{6,7},{4,1}};

        System.out.println(solution(n, path, order));
    }

}
