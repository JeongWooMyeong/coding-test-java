package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 피로도13 {

    static boolean[] visited;
    static int answer;
    static int n;

    public static int solution(int k, int[][] dungeons){
        answer = Integer.MIN_VALUE;

        n = dungeons.length;
        visited = new boolean[n];

        dfs(0, dungeons, k);

        return answer;


    }

    static void dfs(int count, int[][] dungeons, int k){

        answer = Math.max(answer, count);

        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                dfs(count+1, dungeons, k - dungeons[i][1]);
                visited[i] = false;

            }
        }

    }

    public static void main(String[] args) throws Exception{
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        System.out.println(solution(k, dungeons));
    }
}
