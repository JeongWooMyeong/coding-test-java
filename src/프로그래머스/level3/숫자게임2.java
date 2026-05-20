package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 숫자게임2 {

    public static int solution(int[] A, int[] B){
        Arrays.sort(A);
        Arrays.sort(B);

        int a = 0;
        int b = 0;
        int answer = 0;

        while(a < A.length && b < B.length){
            if(B[b] > A[a]){
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
        int[] A = {2,2,2,2};
        int[] B = {1,1,1,1};
        System.out.println(solution(A,B));
    }

}
