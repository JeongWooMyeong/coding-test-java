package 백준.실버.level4;

import java.util.*;

public class ATM {
    static int n;
    static int[] arr;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int sum = 0;
//        for(int i=0;i<n;i++){
//            int interval = 0;
//            for(int j=i;j>=0;j--){
//                interval += arr[j];
//            }
//
//            sum += interval;
//        }
        int prefix = 0;
        for(int i=0;i<n;i++){
            prefix += arr[i];
            sum += prefix;
        }

        System.out.print(sum);

    }
}
