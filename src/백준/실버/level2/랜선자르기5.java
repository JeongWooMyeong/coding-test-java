package 백준.실버.level2;

import java.util.*;
import java.io.*;

public class 랜선자르기5 {

    static int K, N;
    static int[] wires;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        wires = new int[K];

        for(int i=0;i<wires.length;i++){
            wires[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(wires);

        long left = 1;
        long right = wires[wires.length-1];
        long answer = 0;

        while(left <= right){
            long mid = (left + right) / 2;
            long count = 0;
            for(int x : wires){
                count += x / mid;
            }

            if(count >= N){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        System.out.println(answer);

    }

}
