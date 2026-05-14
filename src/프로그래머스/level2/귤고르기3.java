package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 귤고르기3 {
    static Map<Integer, Integer> map;

    public static int solution(int k, int[] tangerine){
        int answer = 0;
        map = new HashMap<>();

        for(int x : tangerine){
           map.put(x , map.getOrDefault(x, 0)+1);
        }

        List<Integer> counter = new ArrayList<>(map.values());
        Collections.sort(counter, Collections.reverseOrder());

        int count = 0;
        for(int x : counter){
            count += x;
            answer++;
            if(count >= k) break;
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        int k = 4;
        int[] tangerine ={1,3,2,5,4,5,2,3};
        System.out.println(solution(k, tangerine));
    }

}
