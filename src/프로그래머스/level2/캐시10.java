package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
Deque 사용
 */

public class 캐시10 {

    static Deque<String> cache;

    public static int solution(int cacheSize, String[] cities){
        cache = new ArrayDeque<>();
        int answer = 0;

        if(cacheSize == 0) return cities.length * 5;

        for(String city : cities){
            city = city.toLowerCase();

            if(cache.contains(city)){

                cache.remove(city);
                cache.addLast(city);

                answer += 1;

            }else{

                if(cacheSize == cache.size()){
                    cache.removeFirst();
                }

                cache.addLast(city);
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
