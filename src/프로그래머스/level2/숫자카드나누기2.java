package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 숫자카드나누기2 {
    public static int solution(int[] arrayA, int[] arrayB){
        int answer = 0; //만족하는거 없을때 0 출력

        //배열 A에 대한 최대 공약수 구하기
        int gcdA = arrayA[0];
        for(int a : arrayA){
            gcdA = gcd(gcdA, a);
        }

        //배열 B에 대한 최대 공약수 구하기
        int gcdB = arrayB[0];
        for(int b : arrayB){
            gcdB = gcd(gcdB, b);
        }

        //최대공약수A가 B배열에 나누어지는지 확인 (나눠지면 false)
        boolean isValidA = true;
        for(int b : arrayB){
            if(b % gcdA == 0){
                isValidA = false;
                break;
            }
        }

        if(isValidA){
            answer = Math.max(answer, gcdA);
        }

        //최대공약수B가 A배열에 나누어지는지 확인
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
    //유클리드 호제법 (최대 공약수 구하기)
    //최소공배수 a*b / gcd(a,b)
    static int gcd(int a, int b){
        while(b != 0){
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
