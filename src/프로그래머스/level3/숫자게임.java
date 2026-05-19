package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 숫자게임 {

    public static int solution(int[] A, int[] B){
        int answer = 0;
        //결국 숫자만 비교하는것이므로 둘다 정렬해도 상관없다
        Arrays.sort(A);
        Arrays.sort(B);

        int a = 0;
        int b = 0;

        while(a < A.length && b < B.length){
            if(B[b] > A[a]){
                answer++;
                a++;
                b++;
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
