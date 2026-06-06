package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 예산2 {

    static int N,M;
    static int[] money;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        N = Integer.parseInt(br.readLine());
        money = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            money[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        Arrays.sort(money);

        int left = 0;
        int right = money[money.length-1];

        while(left <= right){
            int mid = (left + right) / 2;
            int sum = 0;
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
