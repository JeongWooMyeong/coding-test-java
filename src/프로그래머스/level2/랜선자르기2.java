package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 랜선자르기2 {
    static int K,N;
    static int[] wires;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        wires = new int[K];

        for(int i=0;i<K;i++){
            wires[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(wires);

        int left = 1;
        int right = wires[wires.length-1];
        int answer=  0;

        while(left <= right){
            int mid = (left + right) / 2;
            int count = 0;
            for(int i=0;i<K;i++){
                count += wires[i] / mid;
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
