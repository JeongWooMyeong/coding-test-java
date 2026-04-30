package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
최대 공약수 구하기 - 유클리드 호제법
 */

public class 숫자카드나누기 {
    public static int solution(int[] arrayA, int[] arrayB){
        int answer = 0;

        int gcdA = arrayA[0];
        for(int a : arrayA){
            gcdA = gcd(gcdA, a);
        }

        int gcdB = arrayB[0];
        for(int b : arrayB){
            gcdB = gcd(gcdB, b);
        }

        //GCDA가 B배열에 나누어지는지 확인 (나누어 지면 안됌)
        boolean isValidA = true;
        for(int b : arrayB){
            if(b % gcdA == 0){
                isValidA = false;
                break;
            }
        }
        if(isValidA) answer = Math.max(answer, gcdA);

        boolean isValidB = true;
        for(int a : arrayA){
            if(a % gcdB == 0){
                isValidB = false;
                break;
            }
        }
        if(isValidB) answer = Math.max(answer, gcdB);

        return answer;

    }

    static int gcd(int a, int b){
        while(b!=0){
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    public static void main(String[] args) throws Exception{
        int[] arrayA = {10,20};
        int[] arrayB = {5,17};

        System.out.println(solution(arrayA, arrayB));
    }


}
