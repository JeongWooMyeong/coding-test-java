package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 예상대진표2 {

    public static int solution(int n, int a, int b){
        int round = 0;

        while(a != b){
            a = (a+1) / 2;
            b = (b+1) / 2;

            round++;
        }

        return round;

    }

    public static void main(String[] args) throws Exception{
        int N = 8;
        int A = 4;
        int B = 7;
        System.out.println(solution(8,4,7));
    }

}
