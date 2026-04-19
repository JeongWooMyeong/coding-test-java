package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 디스크컨트롤러 {


    static class disk implements Comparable<disk>{
        int start, time;

        public disk(int start, int time){
            this.start = start;
            this.time = time;
        }

        public int compareTo(disk other){
            return this.time - other.time;
        }

    }

    public static int solution(int[][] jobs){
        Arrays.sort(jobs, (a,b)->a[0] - b[0]);
        PriorityQueue<disk> pq = new PriorityQueue<>();

        int idx = 0;    //인덱스
        int count = 0;  //작업수
        int time = 0;   //작업 시작 시간
        int totalTime = 0;  //전체 시간

        while(count < jobs.length){
            //idx가 jobs.length보다 작고 작업시작 시간이 time 보다 작거나 같을때
            //현재 시각까지 도착한 작업들으 큐에 넣기
            while(idx < jobs.length && jobs[idx][0] <= time){
                int start = jobs[idx][0];
                int duration = jobs[idx][1];
                pq.offer(new disk(start, duration));
                idx++;
            }
            //아직 도착한 작업이 없으면 다음 작업으로 점프
            if(pq.isEmpty()){
                time = jobs[idx][0];
            }else{
                //가장 짧은 작업 꺼내서 처리
                disk cur = pq.poll();
                time += cur.time;   //현재 시각을 작업 소요 시간만큼 증가
                totalTime += time - cur.start;  //대기+실행 시간 누적
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
