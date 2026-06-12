package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 줄서는방법6 {

    static List<Integer> people;
    static long fact;

    public static int[] solution(int n, long k){

        people = new ArrayList<>();

        for(int i=0;i<n;i++){
            people.add(i+1);
        }

        fact = 1;
        for(int x : people){
            fact *= x;
        }
        //0 index 시작
        k--;

        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            fact /= (n-i);
            int idx = (int) (k / fact);
            answer[i] = people.get(idx);
            people.remove(idx);
            k %= fact;
        }


        return answer;
    }

    public static void main(String[] args) throws Exception{
        int n = 3;
        int k = 5;

        System.out.println(Arrays.toString(solution(n,k)));
    }

}
