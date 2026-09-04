package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 과제진행하기5 {

    static Stack<Edge> stack;
    static List<String> result;
    static List<Edge> list;
    static class Edge implements Comparable<Edge>{
        String name;
        int start;
        int cost;

        public Edge(String name, int start, int cost){
            this.name = name;
            this.start = start;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return Integer.compare(this.start, other.start);
        }

    }

    public static String[] solution(String[][] plans){
        result = new ArrayList<>();
        list = new ArrayList<>();
        stack = new Stack<>();

        for(String[] plan : plans){
            String name = plan[0];
            int start = toMin(plan[1]);
            int cost = Integer.parseInt(plan[2]);

            list.add(new Edge(name, start, cost));
        }

        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            int nextTime = (i + 1 < list.size()) ? list.get(i+1).start : Integer.MAX_VALUE;

            Edge cur = list.get(i);

            int curTime = cur.start;
            int remain = cur.cost;

            if(curTime + remain <= nextTime){
                result.add(cur.name);
                curTime += remain;

                while(!stack.isEmpty()){
                    Edge prev = stack.pop();
                    if(curTime + prev.cost <= nextTime){
                        result.add(prev.name);
                        curTime += prev.cost;
                    }else{
                        prev.cost -= nextTime - curTime;
                        stack.push(prev);
                        break;
                    }
                }

            }else{
                cur.cost -= nextTime - curTime;
                stack.push(cur);
            }

        }

        while(!stack.isEmpty()){
            result.add(stack.pop().name);
        }


        return result.toArray(new String[0]);
    }

    static int toMin(String time){
        String[] arr = time.split(":");
        int H = Integer.parseInt(arr[0]) * 60;
        int M = Integer.parseInt(arr[1]);

        return H + M;

    }


    public static void main(String[] args) throws Exception{
        String[][] plans = {{"korean","11:40","30"},{"english","12:10","20"},{"math","12:30", "40"}};

        System.out.println(Arrays.toString(solution(plans)));
    }


}
