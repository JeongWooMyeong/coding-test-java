package 이것이코딩테스트다.그리디;

import java.util.*;
import java.io.*;

public class 하나가될때까지3_6 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int K = sc.nextInt();

        int result = 0;

        while(M >= K){
            int target = (M/K) * K;
            result += (M - target);

            M /= K;
            result++;
        }

        result += (M - 1);
        System.out.println(result);
    }


}
