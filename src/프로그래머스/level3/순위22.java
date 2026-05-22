package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 순위22 {
    static ArrayList<ArrayList<Integer>> win;
    static ArrayList<ArrayList<Integer>> lose;
    static boolean[] visited;

    public static int solution(int n, int[][] results){
        win = new ArrayList<>();
        lose = new ArrayList<>();
        int answer = 0;

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
            visited = new boolean[n+1];
            int winCount = dfs(i, win);
            int loseCount = dfs(i, lose);

            if(winCount + loseCount == n-1) answer++;
        }

        return answer;

    }

    static int dfs(int idx, ArrayList<ArrayList<Integer>> list){
        visited[idx] = true;
        int count = 0;

        for(int i=0;i<list.get(idx).size();i++){
            int next = list.get(idx).get(i);
            if(!visited[next]){
                visited[next] = true;
                count += 1 + dfs(next, list);
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
