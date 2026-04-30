package 프로그래머스.level1;

import java.util.*;
import java.io.*;

public class 예산2 {
    public static int solution(int[] d, int budget){
        int answer = 0;

        //아래의 코드를 만족하기 위해서 코인을 작은거부터 사용해야함
        Arrays.sort(d);

        int coin = 0;
        for(int c : d){
            coin += c;
            if(coin <= budget){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] d = {1,3,2,5,4};
        int budget = 9;

        System.out.println(solution(d, budget));
    }
}
