package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 피로도11 {

    static boolean[] visited;
    static int answer = Integer.MIN_VALUE;
    static int n;

    public static int solution(int k, int[][] dungeons){
        n = dungeons.length;

        visited = new boolean[n];

        dfs(dungeons, 0, k);

        return answer;
    }

    static void dfs(int[][] dungeons, int count, int target){

        for(int j=0;j<dungeons.length;j++){
            if(!visited[j] && dungeons[j][0] <= target){
                visited[j] = true;
                dfs(dungeons, count+1, target-dungeons[j][1]);
                visited[j] = false;
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
