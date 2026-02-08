package 이것이코딩테스트다.다이나믹프로그래밍;

import java.util.*;

public class 바닥공사 {
    public static int[] d= new int[1001];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //정수 n 입력받기
        int n = sc.nextInt();

        //다이나믹 프로그래밍 보텀업
        d[1] = 1;
        d[2] = 3;
        for(int i=3;i<=n;i++){
            d[i] = (d[i-1] +2 * d[i-2]) % 796796;
        }

        System.out.println(d[n]);
    }
}
