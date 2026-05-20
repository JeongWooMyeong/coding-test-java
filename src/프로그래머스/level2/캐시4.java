package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
Deque를 이용한 캐시 문제 풀이
오히려 LinkedHashMap보다 쉬운거 같음
contains, remove, addFirst removeFirst, addLast, removeLast 양방향 사용가능

 */

public class 캐시4 {
    static Deque<String> dq;

    public static int solution(int cacheSize, String[] cities){
        dq = new ArrayDeque<>();
        int answer = 0;

        if(cacheSize == 0) return cities.length * 5;

        for(String city : cities){
            city = city.toLowerCase();
            if(dq.contains(city)){
                dq.remove(city);
                dq.addLast(city);
                answer += 1;
            }else{
                if(dq.size() == cacheSize){
                    dq.removeFirst();
                }
                dq.addLast(city);
                answer += 5;
            }
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(solution(cacheSize, cities));
    }

}
