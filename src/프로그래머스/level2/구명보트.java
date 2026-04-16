package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
나는 우선순위큐로 풀어야한다고 생각했는데 틀림
 */

public class 구명보트 {
    public static int solution(int[] people, int limit){
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //오름 차순 정렬
        Arrays.sort(people);

        for(int i=0;i<people.length;i++){
            pq.offer(people[i]);
        }


        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();

            if(a+b <= limit){
                answer++;
            }else{
                if(a < limit){
                    answer++;
                }
                if(b < limit){
                    answer++;
                }
            }

        }

        while(!pq.isEmpty()){
            int remain = pq.poll();
            if(remain < limit){
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
