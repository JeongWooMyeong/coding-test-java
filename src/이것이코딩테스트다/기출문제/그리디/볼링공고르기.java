package 이것이코딩테스트다.기출문제.그리디;

import java.util.*;

public class 볼링공고르기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            if(x <= m){
                arr[i] = x;
            }
        }

        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i] != arr[j]){
                    result += 1;
                }
            }
        }

        System.out.println(result);

    }
}
