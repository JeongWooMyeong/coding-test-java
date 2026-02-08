package 이것이코딩테스트다.다이나믹프로그래밍;

import java.util.*;

public class 효율적인화폐구성 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //정수 N,M를 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();

        //N개의 화폐단위 정보를 입력받기
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int[] d = new int[m+1];
        Arrays.fill(d, 10001);

        //다이나믹 프로그래미 (보텀업)
        d[0] = 0;
        for(int i=0;i<n;i++){
            for(int j= arr[i];j<=m;j++){
                if(d[j-arr[i]] != 10001){
                    d[j] = Math.min(d[j], d[j-arr[i]] +1);
                }
            }
        }

        //계산된 결과 출력
        if(d[m] == 10001){
            System.out.println(-1);
        }else{
            System.out.println(d[m]);
        }
    }

}
