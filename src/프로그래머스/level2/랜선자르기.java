package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 랜선자르기 {
    static int n,k;
    static int[] wires;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        wires = new int[k];

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            wires[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wires);

        int left = 1;
        int right = wires[k-1];
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            int count = 0;
            for(int x : wires){
                count += x / mid;
            }

            if(count >= n){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        System.out.println(answer);

    }

}
