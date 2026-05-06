package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 풍선터트리기 {
    public static int solution(int[] a){
        int answer = 2;     //맨앞, 맨뒤는 왼쪽이나 오른쪽이 업으므로 무조건 가능
        int n = a.length;
        if(n <= 2) return n;

        int[] rightMin = new int[n];
        rightMin[n-1] = a[n-1];
        for(int i=n-2;i>=0;i--){
            rightMin[i] = Math.min(a[i], rightMin[i+1]);
        }

        int[] leftMin = new int[n];
        leftMin[0] = a[0];
        for(int i=1;i<n;i++){
            leftMin[i] = Math.min(leftMin[i-1], a[i]);
        }

        for(int i=1;i<n-1;i++){
            if(leftMin[i-1] > a[i] || rightMin[i+1] > a[i]) answer++;
        }


        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] a = {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33};
        System.out.println(solution(a));
    }

}
