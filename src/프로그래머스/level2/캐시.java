package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 캐시 {

    public static int solution(int cacheSize, String[] cities){
        int answer = 0;
        if(cacheSize == 0) return cities.length * 5;

        Queue<String> cache = new LinkedList<>();

        for(String city : cities){
            boolean found = false;
            city = city.toLowerCase();
            //for문에서 짜면 concurrtion 위험 있음
            for(String c : cache){
                c = c.toLowerCase();
                if(c.equals(city)){
                    cache.remove(c);
                    cache.add(city);
                    answer += 1;
                    found = true;
                }
            }
            if(!found){
                if(cache.size() == cacheSize) {
                    cache.poll();
                }
                    cache.add(city);
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
