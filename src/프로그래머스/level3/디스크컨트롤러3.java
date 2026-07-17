package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 디스크컨트롤러3 {

    static class Disk implements Comparable<Disk>{
        int idx;
        int start;
        int cost;

        public Disk(int idx, int start, int cost){
            this.idx = idx;
            this.start = start;
            this.cost = cost;
        }

        public int compareTo(Disk other){

            if(this.cost == other.cost){
                if(this.start == other.start){
                    return this.idx - other.idx;
                }

                return this.start - other.start;
            }

            return this.cost - other.cost;
        }

    }

    public static int solution(int[][] jobs){

        int idx = 0;
        int count = 0;
        int totalTime = 0;
        int time = 0;

        PriorityQueue<Disk> pq = new PriorityQueue<>();
        Arrays.sort(jobs, (a,b)-> a[0] - b[0]);

        while(count < jobs.length){

            while(idx < jobs.length && jobs[idx][0] <= time){
                pq.offer(new Disk(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if(pq.isEmpty()){
                time = jobs[idx][0];
            }else{
                Disk cur = pq.poll();
                time += cur.cost;
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
