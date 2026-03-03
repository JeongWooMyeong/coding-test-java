package 이것이코딩테스트다2.기출문제.그리디;

import java.util.*;

/*
효율성 테스트에서 안됌
 */

public class 무지의먹방라이브 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //배열개수
        int k = sc.nextInt();   //네트워크 장애 초
        int[] arr = new int[n];
        
        int totaltimes = 0;
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            totaltimes += arr[i];
        }

        //모든 음식을 다 먹었으면 -1 출력
        if(totaltimes <= k){
            System.out.println(-1);
            return;
        }

        int time = 0;
        int idx = 0;
        //k초까지 시뮬레이션
        while(time < k){
            if(arr[idx] > 0){
                arr[idx]--;
                time++;
            }
            idx = (idx + 1) % n;
        }

        //장애 발생 직후 먹을 음ㅁ식 찾기
        while(arr[idx] == 0){
            idx = (idx + 1) % n;
        }

        System.out.println(idx + 1);
    }
}
