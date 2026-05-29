package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 귤고르기4 {

    static Map<Integer, Integer> map;

    public static int solution(int k, int[] tangerine){
        map = new HashMap<>();

        //if(tangerine.length == 1) return 1;

        //귤 종류 개수 구하기
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        List<Integer> counter = new ArrayList<>(map.values());
        Collections.sort(counter, Collections.reverseOrder());

        int answer = 0;
        int count = 0;

        for(int x : counter){
            count += x;
            answer++;
            if(count >= k) break;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int k =6;
        int[] tangerine = {1,3,2,5,4,5,2,3};

        System.out.println(solution(k, tangerine));
    }

}
