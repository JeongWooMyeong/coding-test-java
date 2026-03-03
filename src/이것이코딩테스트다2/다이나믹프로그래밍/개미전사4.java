package 이것이코딩테스트다2.다이나믹프로그래밍;

import java.util.*;

public class 개미전사4 {
    public static int[] d = new int[100];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //정수 N을 입력받기
        int n = sc.nextInt();

        //모든 식량 정보 입력받기
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        //다이나믹 프로그래밍 (보텀업)
        d[0] = arr[0];
        d[1] = Math.max(arr[0], arr[1]);
        for(int i=2;i<n;i++){
            d[i] = Math.max(d[i-1], d[i-2] + arr[i]);
        }

        //계산된 결과 출력
        System.out.println(d[n-1]);

    }
}
