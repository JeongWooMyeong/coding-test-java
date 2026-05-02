package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 캐시2 {

    public static int solution(int cacheSize, String[] cities){
        int answer = 0;

        if(cacheSize == 0) return cities.length * 5;

        Queue<String> cache = new LinkedList<>();

        for(String city : cities){
            city = city.toLowerCase();

            if(cache.remove(city)){
                answer += 1;
                cache.add(city);
            }else{
                if(cache.size() == cacheSize) cache.poll();
                answer += 5;
                cache.add(city);
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
