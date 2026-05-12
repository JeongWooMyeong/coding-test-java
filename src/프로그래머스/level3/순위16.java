package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
bfs
 */

public class 순위16 {
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
        //선수 한명씩 확인
        for(int i=1;i<=n;i++){
            visited = new boolean[n+1];
            int winCount = bfs(i, win);
            int loseCount = bfs(i, lose);

            if(winCount + loseCount == n-1) answer++;
        }

        return answer;
    }

    static int bfs(int start, ArrayList<ArrayList<Integer>> list){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int count = 0;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<list.get(now).size();i++){
                int next = list.get(now).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    count++;
                    q.offer(next);
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
