package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 숫자카드나누기3 {

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
        //철수 배열에 영희 최대공약수 나눠져야 하고
        for(int a : arrayA){
            if(a % gcdB == 0){
                gcdB = 0;
                break;
            }
        }

        for(int b : arrayB){
            if(b % gcdA == 0){
                gcdA = 0;
                break;
            }
        }

        answer = Math.max(gcdA, gcdB);

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
