package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 피로도3
{
    static int answer = 0;
    static boolean[] visited;

    public static int solution(int k, int[][] dungeons){
        visited = new boolean[dungeons.length];

        dfs(0, 0, k, dungeons);

        return answer;
    }

    static void dfs(int idx, int count, int k, int[][] dungeons){

        for(int i=0;i<dungeons.length;i++){
            int[] dun = dungeons[i];
            if(dun[0] <= k && !visited[i]){
                visited[i] = true;
                dfs(idx+1, count+1, k-dun[1], dungeons);
                visited[i] = false;
            }
        }

        answer = Math.max(count, answer);

    }

    public static void main(String[] args) throws Exception{
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        System.out.println(solution(k, dungeons));
    }

}
