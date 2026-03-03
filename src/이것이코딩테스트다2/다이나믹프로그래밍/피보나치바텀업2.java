package 이것이코딩테스트다2.다이나믹프로그래밍;

import java.util.*;

public class 피보나치바텀업2 {
    public static long[] d = new long[100];

    public static void main(String[] args){
        //첫번쨰 피보나치 수와 두번째 피보나치 수는 1
        d[1] = 1;
        d[2] = 1;
        int n =50;  //50번째 피보나치 수를 계산

        //피보나치 함수 반복문으로 구현
        for(int i=3;i<=n;i++){
            d[i] = d[i - 1] + d[i - 2];
        }
        System.out.println(d[n]);
    }
}
