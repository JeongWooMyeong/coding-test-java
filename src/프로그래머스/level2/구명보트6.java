package 프로그래머스.level2;

import java.util.*;

public class 구명보트6 {

    public static int solution(int[] people, int limit){
        int answer = 0;
        //1. 사람인원 오름차순 정렬
        Arrays.sort(people);
        //2. 투 포인터방식
        int left = 0;
        int right = people.length-1;

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
        int[] people = {70,50,80,50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }

}
