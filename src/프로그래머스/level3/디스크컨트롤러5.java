package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 디스크컨트롤러5 {

    static class Edge implements Comparable<Edge>{
        int start;
        int cost;

        public Edge(int start, int cost){
            this.start = start;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return this.cost - other.cost;
        }

    }

    public static int solution(int[][] jobs){
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        Arrays.sort(jobs, (a,b)-> Integer.compare(a[0], b[0]));

        int time = 0;
        int count = 0;
        int totalTime = 0;
        int idx = 0;

        while(count < jobs.length){

            while(idx < jobs.length && jobs[idx][0] <= time){
                pq.offer(new Edge(jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if(pq.isEmpty()){
                time = jobs[idx][0];
            }else{
                Edge cur = pq.poll();
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
