package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 호텔대실2 {
    public static int solution(String[][] book_time){
        int answer = 0;
        //시작 시간 기준 정렬
        Arrays.sort(book_time, (a,b)->a[0].compareTo(b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(String[] book : book_time){
            int start = toSec(book[0]);
            int end = toSec(book[1]) + 600;
            //end 시간이 현재 start보다 작거나 같으며 재사용
            if(!pq.isEmpty() && pq.peek() <= start){
                pq.poll();
            }

            answer++;
            pq.offer(end);
        }

        return pq.size();
    }

    static int toSec(String s){
        String[] time = s.split(":");
        int H = Integer.parseInt(time[0]) * 3600;
        int M = Integer.parseInt(time[1]) * 60;

        return H + M;
    }

    public static void main(String[] args) throws Exception{
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        System.out.println(solution(book_time));
    }


}
