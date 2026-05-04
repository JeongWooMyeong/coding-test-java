package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
bfs로도 풀 수 있을듯?
 */

public class 순위7 {
    static ArrayList<ArrayList<Integer>> win;
    static ArrayList<ArrayList<Integer>> lose;
    static boolean[] visited;

    public static int solution(int n, int[][] results){
        int answer = 0;
        win = new ArrayList<>();
        lose = new ArrayList<>();

        for(int i=0;i<=n;i++){
            win.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }

        for(int[] r : results){
            int a = r[0];
            int b = r[1];
            win.get(a).add(b);
            lose.get(b).add(a);
        }

        for(int i=1;i<=n;i++){
            int winCount = bfs(i, win, n);
            int loseCount = bfs(i, lose, n);

            if(winCount + loseCount == n-1) answer++;
        }

        return answer;
    }

    static int bfs(int start, ArrayList<ArrayList<Integer>> list, int n){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n+1];
        q.offer(start);
        visited[start] = true;
        int count = 0;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<list.get(now).size();i++){
                int next = list.get(now).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception{
        int n = 5;
        int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};

        System.out.println(solution(n, results));
    }

}
