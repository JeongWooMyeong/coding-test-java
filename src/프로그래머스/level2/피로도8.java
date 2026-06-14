package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 피로도8 {

    static boolean[] visited;
    static int n;
    static int answer;

    public static int solution(int k, int[][] dungeons){
        n = dungeons.length;
        visited= new boolean[n];
        answer = Integer.MIN_VALUE;

        dfs(0, k, dungeons);

        return answer;
    }

    static void dfs(int count, int k, int[][] dungeons){

        for(int i=0;i<n;i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                dfs(count+1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }

        answer = Math.max(answer, count);

    }

    public static void main(String[] args) throws Exception{
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        System.out.println(solution(k, dungeons));
    }

}
