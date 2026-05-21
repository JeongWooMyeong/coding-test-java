package 프로그래머스.level2;


import java.util.*;
import java.io.*;

/*
일단 순열 모든 경우의 수 구해보자
근데 시간초과로 20! 할 수없음 -> 제출 불가능
 */

public class 줄서는방법4 {
    static boolean[] visited;
    static long count = 0;
    static int[] answer;
    static List<List<Integer>> setList;

    public static int[] solution(int n, long k){
        visited = new boolean[n+1];
        answer = new int[n];
        setList = new ArrayList<>();

        dfs(0,n, k, new ArrayList<>());

        return answer;
    }

    static void dfs(int depth, int n, long k, List<Integer> path){
        if(depth == n){
            count++;
            if(count == k){
                for(int i=0;i<path.size();i++){
                    answer[i] = path.get(i);
                }
            }
            setList.add(path);
            return;
        }

        for(int i=1;i<=n;i++){
            if(!visited[i]){
                visited[i] = true;
                path.add(i);
                dfs(depth+1, n, k, path);
                visited[i] = false;
                path.remove(path.size()-1);
            }
        }

    }

    public static void main(String[] args) throws Exception{
        int n = 3;
        int k = 5;
        System.out.println(Arrays.toString(solution(n,k)));
    }

}
