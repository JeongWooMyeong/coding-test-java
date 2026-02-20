package 이것이코딩테스트다2.시간복잡도공간복잡도;

import java.util.*;

/*
O(2^n)
재귀 피보나치, 부분집합
 */

public class ExponentialTime {
    public static int fib(int n){
        if(n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args){
        System.out.println("fib(10): " + fib(10));
    }
}
