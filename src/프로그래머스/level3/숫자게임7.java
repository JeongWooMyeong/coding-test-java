package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 숫자게임7 {

    public static int solution(int[] A, int[] B){
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int a = 0;
        int b = 0;

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

}
