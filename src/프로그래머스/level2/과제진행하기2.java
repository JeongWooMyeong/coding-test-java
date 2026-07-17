package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 과제진행하기2 {

    static ArrayList<Plan> list;
    static ArrayList<String> result;
    static Stack<Plan> stack;

    static class Plan{
        String name;
        int start;
        int cost;

        public Plan(String name, int start, int cost){
            this.name = name;
            this.start = start;
            this.cost = cost;
        }

    }

    public static String[] solution(String[][] plans){
        list = new ArrayList<>();
        result = new ArrayList<>();
        Arrays.sort(plans, (a,b)->a[1].compareTo(b[1]));
        stack = new Stack<>();

        for(String[] plan : plans){
            String name = plan[0];
            int start = toMin(plan[1]);
            int cost = Integer.parseInt(plan[2]);

            list.add(new Plan(name, start, cost));
        }

        for(int i=0;i<list.size();i++){
            Plan cur = list.get(i);
            int nextTime = i < list.size()-1 ? list.get(i+1).start : Integer.MAX_VALUE;
            int remain = cur.cost;

            if(cur.start + remain <= nextTime){
                result.add(cur.name);
                int curTime = cur.start + remain;

                while(!stack.isEmpty()){
                    Plan prev = stack.pop();
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
                cur.cost -= nextTime - cur.start;
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
