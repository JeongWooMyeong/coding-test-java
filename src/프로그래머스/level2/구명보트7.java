package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 구명보트7 {

    public static int solution(int[] people, int limit){
        Arrays.sort(people);

        int left = 0;
        int right = people.length-1;
        int answer = 0;

        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
                right--;
                answer++;
            }else{
                right--;
                answer++;
            }


        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        System.out.println(solution(people,limit));

    }

}
