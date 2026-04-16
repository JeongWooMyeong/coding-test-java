package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 구명보트2 {
    public static int solution(int[] people, int limit){
        int answer = 0;

        Arrays.sort(people);
        //투포인터 방식 -> 배열 오름차순 정렬하여 처음 과 끝 비교하면서 가는 방법
        int left = 0;
        int right = people.length-1;
        //마지막 사람까지 처리이므로 < 아닌 <=
        while(left <= right){
            //최소 + 최대 limit 이하일때 다포함이므로 left, right 값 조정
            if(people[left] + people[right] <= limit){
                left++;
                right--;
            //아니면 최대값 혼자 넣어야하므로 right만 감소
            }else{
                right--;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] people = {70,50,80,50};
        int limit = 100;

        System.out.println(solution(people, limit));

    }
}
