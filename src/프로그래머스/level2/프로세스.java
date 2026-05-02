package 프로그래머스.level2;

import java.util.*;
import java.io.*;
/*
단순하게 생각해서 우선순위 큐로 했는데 문제의 요구사항을 만족 못함

 */

public class 프로세스 {
    static ArrayList<Node> edges;
    static List<Integer> result;

    static class Node implements Comparable<Node>{
        int process;
        int cost;
        int idx;

        public Node(int process, int cost, int idx){
            this.process = process;
            this.cost = cost;
            this.idx = idx;
        }

        public int compareTo(Node other){
            return other.cost - this.cost;
        }

    }


    public static int solution(int[] priorities, int location){
        int answer = 0;
        result = new ArrayList<>();
        edges = new ArrayList<>();

        int idx = 0;
        for(int pr : priorities){
            edges.add(new Node(idx, pr, idx));
            idx++;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<edges.size();i++){
            pq.offer(edges.get(i));
        }

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            result.add(cur.idx);
        }

        for(int i=0;i<result.size();i++){
            if(result.get(i) == location){
                answer = i;
                break;
            }
        }
        return answer+1;

    }

    public static void main(String[] args) throws Exception{
        int[] priorities = {2,1,3,2};
        int location = 2;

        System.out.println(solution(priorities, location));

    }

}
