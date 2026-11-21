package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 디스크컨트롤러11 {

    static PriorityQueue<Edge> pq;
    static class Edge implements Comparable<Edge>{
        int num;
        int start;
        int cost;

        public Edge(int num, int start, int cost){
            this.num = num;
            this.start = start;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return Integer.compare(this.cost, other.cost);
        }

    }

    public static int solution(int[][] jobs){
        Arrays.sort(jobs, (a,b)->Integer.compare(a[0],b[0]));

        pq = new PriorityQueue<>();

        int idx = 0;
        int total = 0;
        int count = 0;
        int time = 0;

        while(count < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= time){
                pq.offer(new Edge(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if(pq.isEmpty()){
                time = jobs[idx][0];
            }else{
                Edge cur = pq.poll();
                time += cur.cost;
                total += time - cur.start;
                count++;
            }

        }

        return total / count;
    }

    public static void main(String[] args) throws Exception{
        int[][] jobs = {{0,3},{1,9},{3,5}};
        System.out.println(solution(jobs));
    }

}
