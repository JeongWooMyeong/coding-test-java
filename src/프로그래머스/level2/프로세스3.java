package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 프로세스3 {

    static ArrayList<Node> nodeList;
    static ArrayList<Integer> resultList;

    static class Node{
        int process;
        int cost;
        int idx;

        public Node(int process, int cost, int idx){
            this.process = process;
            this.cost = cost;
            this.idx = idx;
        }

    }

    public static int solution(int[] priorities, int location){
        nodeList = new ArrayList<>();
        resultList = new ArrayList<>();

        for(int i=0;i<priorities.length;i++){
            nodeList.add(new Node(i, priorities[i], i));
        }

        Queue<Node> q = new LinkedList<>();
        for(Node node : nodeList){
            q.offer(node);
        }

        while(!q.isEmpty()){
            Node cur = q.poll();
            boolean found = false;
            for(Node n : q){
                if(cur.cost < n.cost){
                    q.offer(cur);
                    found = true;
                    break;
                }
            }

            if(!found) resultList.add(cur.idx);

        }

        int answer = 0;
        for(int i=0;i<resultList.size();i++){
            if(resultList.get(i) == location){
                answer = i;
            }
        }

        //몇번째 부터 시작되는지므로 1부터 시작
        return answer+1;

    }

    public static void main(String[] args) throws Exception{
        int[] priorities = {2,1,3,2};
        int location = 2;

        System.out.println(solution(priorities, location));
    }

}
