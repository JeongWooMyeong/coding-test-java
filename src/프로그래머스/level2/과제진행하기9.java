package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 과제진행하기9 {

    static List<Edge> edges;
    static List<String> result;
    static Deque<Edge> dq;
    static class Edge{
        String name;
        int start;
        int cost;

        public Edge(String name, int start, int cost){
            this.name = name;
            this.start = start;
            this.cost = cost;
        }

    }

    public static String[] solution(String[][] plans){
        result = new ArrayList<>();
        dq = new ArrayDeque<>();
        edges = new ArrayList<>();

        Arrays.sort(plans, (a,b)->a[1].compareTo(b[1]));

        for(String[] plan : plans){
            String name = plan[0];
            int start = toMin(plan[1]);
            int cost = Integer.parseInt(plan[2]);

            edges.add(new Edge(name, start, cost));
        }

        for(int i=0;i<edges.size();i++){
            int nextTime = i+1 < edges.size() ? edges.get(i+1).start : Integer.MAX_VALUE;
            Edge cur = edges.get(i);

            int curTime = cur.start;
            int remain = cur.cost;

            if(curTime + remain <= nextTime){
                result.add(cur.name);
                curTime += remain;

                while(!dq.isEmpty()){
                    Edge prev = dq.pollLast();

                    if(curTime + prev.cost <= nextTime){
                        result.add(prev.name);
                        curTime += prev.cost;
                    }else{
                        prev.cost -= nextTime - curTime;
                        dq.addLast(prev);
                        break;
                    }

                }

            }else{
                cur.cost -= nextTime - curTime;
                dq.addLast(cur);
            }


         }

        return result.toArray(new String[0]);

    }

    static int toMin(String number){
        String[] arr = number.split(":");

        int H = Integer.parseInt(arr[0]) * 60;
        int M = Integer.parseInt(arr[1]);

        return H + M;
    }

    public static void main(String[] args) throws Exception{
        String[][] plans = {{"korean","11:40","30"},{"english","12:10","20"},{"math","12:30","40"}};

        System.out.println(Arrays.toString(solution(plans)));
    }

}
