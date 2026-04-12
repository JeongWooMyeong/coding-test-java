package 백준.골드.level2;

import java.util.*;
import java.io.*;

public class 저울3 {
    static int N;
    static int[] weights;
    static long reusult = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        weights = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            weights[i] = Integer.parseInt(st.nextToken());
        }

        //순서대로 해야함
        Arrays.sort(weights);

        long sum = 0;
        for(int i=0;i<N;i++){
            if(weights[i] > sum+1){
                break;
            }

            sum += weights[i];
        }

        System.out.println(sum+1);


    }

}
