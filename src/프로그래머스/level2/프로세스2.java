package 프로그래머스.level2;

import java.util.*;
import java.io.*;
/*
큐로 풀고
하나 poll 하면서
남아있는 큐 (향상된 for문) 비교해서 더 큰 값 있는지 확인
있으면 현재 cur을 다시 큐에 넣고
아니면 list에 담거나 count 세기
 */

public class 프로세스2 {
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

        Queue<Node> q= new LinkedList<>();
        for(int i=0;i<edges.size();i++){
            q.offer(edges.get(i));
        }

        while(!q.isEmpty()){
            Node cur = q.poll();
            boolean found = false;
            //향상된 for문 가능?
            for(Node n : q){
                if(cur.cost < n.cost){
                    q.offer(cur);
                    found = true;
                    break;
                }
            }

            if(!found) result.add(cur.idx);


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
