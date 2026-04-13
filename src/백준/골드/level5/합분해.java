package 백준.골드.level5;

import java.util.*;
import java.io.*;

/*
dfs로 풀어보럿임
이방법은 시간초과 때문에 안됌
 */

public class 합분해 {
    static int N,K;
    static long answer = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dfs(0, 0);

        System.out.println(answer % 1000000000);
    }

    static void dfs(int sum, int cnt){
        if(cnt == K){
            if(sum == N) answer++;
            return;
        }

        for(int i=0;i<=N;i++){
            if(sum + i > N) break;
            dfs(sum + i, cnt+1);
        }

    }

}
