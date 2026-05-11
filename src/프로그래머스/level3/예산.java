package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 예산 {
    static int n,m;
    static int[] profit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        profit = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            profit[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(profit);

        m = Integer.parseInt(br.readLine());    //예산 한게

        int left = 0;
        int right = profit[n-1];
        int answer = Integer.MIN_VALUE;

        while(left <= right){
            int mid = (left + right) / 2;
            int sum = 0;
            for(int x : profit){
                if(x <= mid) sum += x;
                else sum += mid;
            }

            if(sum <= m){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(answer);


    }

}
