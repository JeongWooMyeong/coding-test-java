package 이것이코딩테스트다.기출문제.그리디;

import java.util.*;

public class 만들수없는금액 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] d = new int[n];

        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            d[i] = x;
        }

        Arrays.sort(d);
        int target = 1;

        for(int i=0;i<n;i++){
            int x = d[i];
            if(target < x){
                break;
            }
            target += x;
        }

        System.out.println(target);

    }
}
