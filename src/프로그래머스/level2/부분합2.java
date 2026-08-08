package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 부분합2 {

    static int N,S;
    static int[] prefix;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        prefix = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            prefix[i] = prefix[i-1] + Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int answer = Integer.MAX_VALUE;

        for(int right=1;right<=N;right++){
            while(prefix[right] - prefix[left-1] >= S){
                answer = Math.min(answer, right - left + 1);
                left++;
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);

    }

}
