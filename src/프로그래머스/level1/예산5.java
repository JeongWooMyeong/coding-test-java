package 프로그래머스.level1;

import java.util.*;
import java.io.*;

/*
이진 탐색의 방법으로 할 수 있다.
누적합 앞에서부터 0번째 ~ n까지
left = 0;
right = d.length-1
까지하고
만약 if(prefix[mid-1] <= budget mid를 늘려야지
아니면 mid를 줄임
 */

public class 예산5 {

    public static int solution(int[] d, int budget){
        int n = d.length;
        int[] prefix = new int[n];
        int answer = 0;
        Arrays.sort(d);
        prefix[0] = d[0];
        //누적합 이전까지
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + d[i];
        }

        int left = 0;
        int right = n - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(prefix[mid] <= budget){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }
        return answer+1;

    }
    public static void main(String[] args) throws Exception{
        int[] d = {1,3,2,5,4};
        int budget = 9;
        System.out.println(solution(d, budget));
    }


}
