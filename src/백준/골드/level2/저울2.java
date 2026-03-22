package 백준.골드.level2;

import java.util.*;
import java.io.*;

/*
sum + 1
 */

public class 저울2 {
    static int N;
    static int[] weights;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        weights = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            weights[i] = Integer.parseInt(st.nextToken());
        }

        //저울추 낮은 순으로 정렬하고 해야함
        Arrays.sort(weights);

        int sum = 0;
        for(int i=0;i<N;i++){
            if(weights[i] > sum + 1){
                break;
            }
            sum += weights[i];
        }

        System.out.print(sum+1);

    }

}
