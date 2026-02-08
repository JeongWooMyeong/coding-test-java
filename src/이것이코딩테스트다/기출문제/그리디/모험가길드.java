package 이것이코딩테스트다.기출문제.그리디;

import java.util.*;

public class 모험가길드 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int cnt = 0;
        int result = 0;
        for(int i=0;i<n;i++){
            cnt += 1;
            if(cnt >= arr[i]){
                result += 1;
                cnt = 0;
            }

        }

        System.out.println(result);

    }

}
