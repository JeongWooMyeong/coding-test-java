package 백준.골드.level2;

import java.util.*;
import java.io.*;

public class 저울 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] weights = new int[N];

        for(int i=0;i<N;i++){
            weights[i] = sc.nextInt();
        }

        Arrays.sort(weights);

        long sum = 0;
        for(int w : weights){
            if(w > sum+1){
                //gap 발생 -> sum+1 무게는 만들 수 없음
                break;
            }
            sum += w;
        }

        System.out.println(sum+1);

    }
}
