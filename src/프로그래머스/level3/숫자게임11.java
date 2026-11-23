package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 숫자게임11 {

    static int answer;
    static int a,b;

    public static int solution(int[] A, int[] B){
        answer = 0;
        a = 0;
        b = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        while(a < A.length && b < B.length){
            if(A[a] < B[b]){
                a++;
                b++;
                answer++;
            }else{
                b++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};

        System.out.println(solution(A,B));
    }

}
