package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 순위5 {
    static ArrayList<ArrayList<Integer>> win = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> lose = new ArrayList<>();
    static boolean[] visited;

    public static int solution(int n, int[][] results){
        int answer = 0;
        for(int i=0;i<=n;i++){
            win.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }

        for(int[] r : results){
            int a = r[0];
            int b = r[1];

            win.get(a).add(b);  //a가 b를 이김
            lose.get(b).add(a); //b가 a한테 짐

        }

        for(int i=1;i<=n;i++) {
            visited = new boolean[n+1];
            int winCount = dfs(win, i);
            int loseCount = dfs(lose, i);

            if(winCount + loseCount == n-1) answer++;

        }


        return answer;
    }

    static int dfs(ArrayList<ArrayList<Integer>> list, int idx){
        int count = 0;
        visited[idx] = true;

        for(int i=0;i<list.get(idx).size();i++){
            int next = list.get(idx).get(i);
            if(!visited[next]){
                visited[next] = true;
                count += 1 + dfs(list, next);
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
