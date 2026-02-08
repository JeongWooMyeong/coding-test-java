package 이것이코딩테스트다.다이나믹프로그래밍;

import java.util.*;

public class 하나로만들기 {

    //앞서 계산된 결과를 저장하기 위한 dp 테이블 초기화
    public static int[] d = new int[300001];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        //다이나믹 프로그래밍 (Dynamic Programming) 진행 (보텀업0
        for(int i=2;i<=x;i++){
            //현재의 수에서 1을 빼는 경우
            d[i] = d[i-1] + 1;
            //현재의 수가 2로 나누어 떨어지는 경우
            if(i % 2 == 0)
                d[i] = Math.min(d[i], d[i/2] + 1);
            //현재의 수가 3으로 나누어 떨어지는 경우
            if(i % 3 == 0)
                d[i] = Math.min(d[i], d[i/3] + 1);
            if(i % 5 == 0)
                d[i] = Math.min(d[i], d[i/5] + 1);
        }

        System.out.println(d[x]);
    }
}
