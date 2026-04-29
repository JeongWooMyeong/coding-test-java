package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 줄서는방법2 {

    public static int[] solution(int n, long k){
        List<Integer> people = new ArrayList<>();
        int[] answer = new int[n];

        for(int i=1;i<=n;i++){
            people.add(i);
        }

        long fact = 1;
        for(int i=1;i<=n;i++){
            fact *= i;  //n!
        }

        k--;     //0 index

        for(int i=0;i<n;i++){
            fact /= (n - i);
            int idx = (int) (k / fact);
            System.out.print("i " + i + " idx : " + idx);
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
