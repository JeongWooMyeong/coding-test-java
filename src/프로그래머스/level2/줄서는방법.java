package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 줄서는방법 {
    static List<List<Integer>> result;
    static boolean[] visited;
    static int count = 0;
    static int[] answer;
    public static int[] solution(int n, long k){
        int[] people = new int[n+1];
        visited = new boolean[n+1];
        result = new ArrayList<>();
        answer = new int[n];

        for(int i=1;i<=n;i++){
            people[i] = i;
        }

        List<Integer> arr = new ArrayList<>();
        dfs(1, 0, n, k, people, arr);

        return answer;

    }

    static void dfs(int idx, int depth, int n, long k, int[] people, List<Integer> list){
        //boolean[] visited = new boolean[n+1];

        if(depth == n){
            count++;

            if(count == k){
                for(int i=0;i<list.size();i++){
                    answer[i] = list.get(i);
                }
            }

            return;

        }

        for(int i=1;i<=n;i++){
            if(!visited[i]) {
                list.add(people[i]);
                visited[i] = true;
                dfs(i + 1, depth + 1, n, k, people, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws Exception{
        int n = 3;
        int k = 5;

        System.out.println(Arrays.toString(solution(n, k)));
    }

}
