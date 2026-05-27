package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 피로도6 {
    static boolean[] visited;
    static int answer;

    public static int solution(int k, int[][] dungeons){
        answer = Integer.MIN_VALUE;

        visited = new boolean[dungeons.length];
        dfs(0, dungeons, k);

        return answer;

    }

    static void dfs(int count, int[][] dungeons, int k){

        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                dfs(count+1, dungeons, k - dungeons[i][1]);
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
