package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class N으로표현9 {

    static List<Set<Integer>> set;

    public static int solution(int N, int number){
        set = new ArrayList<>();

        for(int i=0;i<=8;i++){
            set.add(new HashSet<>());
        }

        int concat = 0;
        for(int i=1;i<=8;i++){
            concat = 10 * concat + N;
            set.get(i).add(concat);
        }


        for(int i=1;i<=8;i++){
            //처음에 발견될 수 있고
            if(set.get(i).contains(number)) return i;
            for(int j=1;j<i;j++){
                for(int a : set.get(j)){
                    for(int b : set.get(i-j)){
                        set.get(i).add(a+b);
                        set.get(i).add(a-b);
                        set.get(i).add(a*b);
                        if(b!=0) set.get(i).add(a/b);
                    }
                }
            }
            //조합 사칙연산후 발견될 수 있음.
            if(set.get(i).contains(number)) return i;
        }
        //8번 시도후에는 찾을 수 없으므로 -1
        return -1;

    }

    public static void main(String[] args) throws Exception{
        int N = 5;
        int number = 12;

        System.out.println(solution(N, number));
    }

}
