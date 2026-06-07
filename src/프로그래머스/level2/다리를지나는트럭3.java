package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 다리를지나는트럭3 {

    public static int solution(int bridge_length, int weight, int[] truck_weights){
        Queue<Integer> q = new LinkedList<>();

        //아 다리 길이만큼 초기화 해주면 되는구나 그러면 2개씩..
        for(int i=0;i<bridge_length;i++){
            q.offer(0);
        }

        int idx = 0;
        int time = 0;
        int totalWeight = 0;
        while(!q.isEmpty()){
            time++;
            totalWeight -= q.poll();

            if(idx < truck_weights.length){
                if(totalWeight + truck_weights[idx] <= weight) {
                    q.offer(truck_weights[idx]);
                    totalWeight += truck_weights[idx];
                    idx++;
                }else{
                    q.offer(0);
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
