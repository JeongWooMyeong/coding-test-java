package 백준.실버.level3;

import java.util.*;

public class 피보나치함수 {
    static int t;
    static int count0 = 0, count1 = 0;
    static int[] arr;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        arr = new int[t];

        for(int i=0;i<t;i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0;i<t;i++){
            fibonacci(arr[i]);
            System.out.println(count0 + " " + count1);
            count0 = 0;
            count1 = 0;
        }

    }

    static int fibonacci(int n){
        if(n==0){
            count0++;
            return 0;
        }else if(n == 1){
            count1++;
            return 1;
        }else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

}
