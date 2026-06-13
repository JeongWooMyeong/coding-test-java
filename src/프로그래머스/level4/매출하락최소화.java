package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 매출하락최소화 {

    static ArrayList<ArrayList<Integer>> edges;
    static int n;
    static int[][] dp;

    public static int solution(int[] sales, int[][] links){
        n = sales.length;
        edges = new ArrayList<>();
        dp = new int[n+1][2];
        int answer = Integer.MAX_VALUE;

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        for(int[] l : links){
            int a = l[0];
            int b = l[1];

            edges.get(a).add(b);

        }

        dfs(1, sales);


        answer = Math.min(dp[1][0], dp[1][1]);

        return answer;


    }

    static void dfs(int node, int[] sales){
        dp[node][0] = 0;
        dp[node][1] = sales[node-1];

        if(edges.get(node).isEmpty()) return;

        int extra = Integer.MAX_VALUE;
        boolean hasAttend = false;


        for(int child : edges.get(node)){

            dfs(child, sales);

            dp[node][0] += Math.min(dp[child][0], dp[child][1]);
            dp[node][1] += Math.min(dp[child][0], dp[child][1]);

            if(dp[child][1] <= dp[child][0]){
                hasAttend = true;
            }else{
                extra = Math.min(extra, dp[child][1] - dp[child][0]);
            }

        }

        if(!hasAttend){
            dp[node][0] += extra;
        }

    }

    public static void main(String[] args) throws Exception{
        int[] sales = {14, 17, 15, 18, 19, 14, 13, 16, 28, 17};
        int[][] links = {{10, 8},{1,9},{9,7},{5,4},{1,5},{5,10},{10,6},{1,3},{10,2}};

        System.out.println(solution(sales, links));
    }

}
