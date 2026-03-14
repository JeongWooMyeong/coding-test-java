package 백준.실버.level4;

import java.util.*;
import java.io.*;

public class 수묶기 {
    static int n;
    static int[] arr;
    static boolean hasZero = false;
    static int sum = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Integer> negative = new PriorityQueue<>();  //최소 힙 (음수)
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());   //최대 힙 (양수)

        for(int x : arr){
            if(x > 1) positive.offer(x);
            else if(x == 1) sum += 1;
            else if(x < 0) negative.offer(x);
            else hasZero = true;
        }

        while(positive.size() > 1){
            int a = positive.poll();
            int b = positive.poll();
            sum += a*b;
        }
        if(!positive.isEmpty()){
            sum += positive.poll();
        }

        while(negative.size() > 1){
            int a = negative.poll();
            int b = negative.poll();
            sum += a * b;
        }

        if(!negative.isEmpty()){
            if(!hasZero) sum += negative.poll();    //0 없으면 그냥 더하기
            else sum += negative.poll();
        }

        System.out.print(sum);

    }

}
