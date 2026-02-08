package 이것이코딩테스트다.다이나믹프로그래밍;

import java.util.*;

public class 피보나치수열2 {
    //한번 계산된 결과를 메모이제이션(memoization)하기 위한 배열 초기화
    public static long[] d = new long[100];

    //피보나치 함수를 재귀함수ㄹ 구현 (탑다운 다이나믹 프로그래밍)
    public static long fibo(int x){
        //종료 조건 (1 혹은2일때 1을 반환
        if(x == 1 || x == 2){
            return 1;
        }
        //이미 계산한적 있는 문제라면 그대로 반환
        if(d[x] != 0){
            return d[x];
        }

        //아직 계산하지 않은 문제라면 점화식에 따라 피보나치 결과 반환
        d[x] = fibo(x-1) + fibo(x-2);
        return d[x];
    }

    public static void main(String[] args){
        System.out.println(fibo(50));
    }

}
