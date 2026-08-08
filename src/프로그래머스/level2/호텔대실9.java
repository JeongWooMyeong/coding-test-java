package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
우선순위 큐 사용
 */

public class 호텔대실9 {

    static PriorityQueue<Integer> pq;

    public static int solution(String[][] book_time){
        pq = new PriorityQueue<>();
        Arrays.sort(book_time, (a,b)->a[0].compareTo(b[0]));
        int room = 0;

        for(String[] book : book_time){
            int start = toMin(book[0]);
            int end = toMin(book[1]) + 10;

            if(!pq.isEmpty() && start >= pq.peek()){
                pq.poll();
            }else{
                room++;
            }

            pq.offer(end);

        }

        return room;

    }

    static int toMin(String time){
        String[] arr = time.split(":");
        int H = Integer.parseInt(arr[0]) * 60;
        int M = Integer.parseInt(arr[1]);

        return H + M;
    }

    public static void main(String[] args) throws Exception{
        String[][] book_time = {{"15:00","17:00"},{"16:40","18:20"},{"14:20","15:20"},{"14:10","19:20"},{"18:20","21:20"}};

        System.out.println(solution(book_time));
    }


}
