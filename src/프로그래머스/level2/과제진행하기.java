package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 과제진행하기 {

    static List<Plan> list;
    static List<String> result;

    static class Plan{
        String name;
        int time;
        int cost;

        public Plan(String name, int time, int cost){
            this.name = name;
            this.time = time;
            this.cost = cost;
        }

    }

    public static String[] solution(String[][] plans){
        Arrays.sort(plans, (a,b)-> a[1].compareTo(b[1]));
        Stack<Plan> stack = new Stack<>();
        list = new ArrayList<>();
        result = new ArrayList<>();

        for(String[] arr : plans){
            String name = arr[0];
            int time = toMin(arr[1]);
            int cost = Integer.parseInt(arr[2]);

            list.add(new Plan(name, time, cost));

        }

        for(int i=0;i<list.size();i++){
            Plan cur = list.get(i);
            int nextTime = (i < list.size() -1)? list.get(i+1).time : Integer.MAX_VALUE;
            int remain = cur.cost;

            if(cur.time + remain <= nextTime){
                result.add(cur.name);
                int curTime = cur.time + remain;

                while(!stack.isEmpty()){
                    Plan prev = stack.pop();
                    if(curTime + prev.cost <= nextTime){
                        curTime += prev.cost;
                        result.add(prev.name);
                    }else{
                        prev.cost -= nextTime - curTime;
                        stack.push(prev);
                        break;
                    }
                }
            }else{
                cur.cost -= nextTime - cur.time;
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
