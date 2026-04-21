package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class N으로표현2 {
    public static int solution(int N, int number){
        //중복 방지
        List<Set<Integer>> dp = new ArrayList<>();
        //Set 초기화 (최대 8번 문제에서 주어짐)
        for(int i=0;i<=8;i++){
            dp.add(new HashSet<>());
        }
        //Nㅇ로 조합할 수 잇는 이을수있는 개수 우선 넣기
        //N = 5 -> 5, 55, 555, 5555....
        int concat = 0;
        for(int i=1;i<=8;i++){
            concat = (10 * concat) + N;
            dp.get(i).add(concat);
        }
        
        //8번까지 진행
        for(int i=1;i<=8;i++){
            //우선 위에서 이은 값이 number이면 i 리턴
            if(dp.get(i).contains(number)) return i;
            //i번 실행하기 위한 방법 j번 하면 i-j 하면 이거 합치면 i번
            for(int j=1;j<i;j++){
                for(int a : dp.get(j)){
                    for(int b : dp.get(i-j)){
                        dp.get(i).add(a+b);
                        dp.get(i).add(a-b);
                        dp.get(i).add(a*b);
                        if(b != 0) dp.get(i).add(a/b);
                    }
                }
            }

            if(dp.get(i).contains(number)) return i;
        }


        //8번 넘어가면 -1 리턴
        return -1;

    }

    public static void main(String[] args) throws Exception{
        int N = 5;
        int number = 12;
        System.out.println(solution(N, number));
    }
}
