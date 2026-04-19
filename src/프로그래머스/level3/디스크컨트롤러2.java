package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 디스크컨트롤러2 {

    static class disk implements Comparable<disk>{
        int start, time;

        public disk(int start, int time){
            this.start = start;
            this.time = time;
        }
        //걸리는 시간 짧은것 부터
        public int compareTo(disk other){
            return this.time - other.time;
        }

    }

    public static int solution(int[][] jobs){
        //작업들 요청시각 빠른것부터 정렬
        Arrays.sort(jobs, (a,b)->a[0] - b[0]);
        PriorityQueue<disk> pq = new PriorityQueue<>();

        int idx = 0;
        int count = 0;  //걸리는 시간
        int time = 0;   //현재 시각
        int totalTime = 0;  //총걸리는 시간

        while(count < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= time){
                pq.offer(new disk(jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if(pq.isEmpty()){
                time = jobs[idx][0];
            }else{
                //작업시작
                disk cur = pq.poll();
                time += cur.time;
                totalTime += time - cur.start;
                count++;
            }
        }

        return totalTime / count;

    }

    public static void main(String[] args) throws Exception{
        int[][] jobs = {{0,3},{1,9},{3,5}};
        System.out.println(solution(jobs));
    }
}
