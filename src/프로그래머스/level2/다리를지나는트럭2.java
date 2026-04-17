package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 다리를지나는트럭2 {
    public static int solution(int bridge_length, int weight, int[] truck_weights){
        Queue<Integer> bridge = new LinkedList<>();

        int totalWeight = 0;
        int time = 0;
        //큐 초기화
        for(int i=0;i<bridge_length;i++){
            bridge.offer(0);
        }

        int idx = 0;
        while(!bridge.isEmpty()){
            time++;
            totalWeight -= bridge.poll();

            if(idx < truck_weights.length) {
                if (totalWeight + truck_weights[idx] <= weight) {
                    bridge.offer(truck_weights[idx]);
                    totalWeight += truck_weights[idx];
                    idx++;
                } else {
                    bridge.offer(0);
                }
            }

        }


        return time;

    }

    public static void main(String[] args) throws Exception{
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }
}
