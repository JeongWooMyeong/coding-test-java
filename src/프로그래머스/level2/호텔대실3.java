package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 호텔대실3 {

    public static int solution(String[][] book_time){
        Arrays.sort(book_time, (a,b)->a[0].compareTo(b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(String[] book : book_time){
            int start = toSec(book[0]);
            int end = toSec(book[1]) + 600; //쉬는시간 10분

            if(!pq.isEmpty() && pq.peek() <= start){
                pq.poll();
            }

            pq.offer(end);

        }

        return pq.size();
    }

    static int toSec(String time){
        String[] arr = time.split(":");
        int H = Integer.parseInt(arr[0]) * 3600;
        int M = Integer.parseInt(arr[1]) * 60;

        return H + M;
    }

}
