package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 캐시16 {

    static Deque<String> dq;

    public static int solution(int cacheSize, String[] cities){
        int answer = 0;

        if(cacheSize == 0) return cities.length * 5;

        dq = new ArrayDeque<>();

        for(String city : cities){
            city = city.toLowerCase();

            if(dq.contains(city)){
                dq.remove(city);
                dq.addLast(city);
                answer += 1;
            }else{
                if(cacheSize == dq.size()){
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
