package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 예산4 {

    static int N;
    static int[] money;
    static int M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        money = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            money[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        Arrays.sort(money);

        long answer = 0;
        long left = 0;
        long right = money[money.length-1];

        while(left <= right){
            long mid = (left + right) / 2;
            long sum = 0;
            for(int x : money){
                if(x < mid){
                    sum += x;
                }else{
                    sum += mid;
                }
            }

            if(sum <= M){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }


        System.out.println(answer);

    }

}
