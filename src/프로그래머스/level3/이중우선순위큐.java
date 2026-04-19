package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 이중우선순위큐 {
    public static int[] solution(String[] operations){
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for(String str : operations){
            String[] command = str.split(" ");
            String type = command[0];
            int value = Integer.parseInt(command[1]);

            if("I".equals(type)){
                maxheap.offer(value);
                minheap.offer(value);
            }else{
                //if(maxheap.isEmpty() || minheap.isEmpty()) continue;

                if(value == 1){
                    if(!maxheap.isEmpty()) {
                        int max = maxheap.poll();
                        //remove는 상관없음
                        minheap.remove(max);
                    }
                }else{
                    if(!minheap.isEmpty()) {
                        int min = minheap.poll();
                        //remove는 상관없음
                        maxheap.remove(min);
                    }
                }

            }

        }

        int[] answer = new int[2];
        if(!maxheap.isEmpty()){
            answer[0] = maxheap.peek();
        }else{
            answer[0] = 0;
        }

        if(!minheap.isEmpty()){
            answer[1] = minheap.peek();
        }else{
            answer[1] = 0;
        }

        return answer;

    }
    public static void main(String[] args) throws Exception{
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        System.out.println(Arrays.toString(solution(operations)));
    }

}
