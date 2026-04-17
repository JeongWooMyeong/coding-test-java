package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 다리를지나는트럭 {

    public static int solution(int bridge_length, int weight, int[] truck_weights){

        Queue<Integer> bridge = new LinkedList<>();

        //다리위에 트럭 총 무게
        int totalWeight = 0;
        //모든 트럭이 지나가는데 걸리는 시간
        int time =0;


        for(int truck : truck_weights){
            while(true) {
                //다리가 비어 있을때
                if (bridge.isEmpty()) {
                    totalWeight += truck;
                    time++;
                    bridge.offer(truck);
                    break;
                    //큐에들어있는 ㅏ이즈가 bridge 길이랑 같을때
                } else if (bridge.size() == bridge_length) {
                    //while(!bridge.isEmpty()){
                    totalWeight -= bridge.poll();
                    //time++;
                    //}
                }
                //다리가 비어있지 않을때
                else {
                    //사이즈가 아직 bridge 길이가 아니라면
                    //현재 있는 total에 트럭이 추가되었을때 무게 확인
                    if (totalWeight + truck <= weight) {
                        bridge.offer(truck);
                        //총무게 증가
                        totalWeight += truck;
                        time++;
                        break;
                    }
                    //무게를 넘어가버리면 그냥 다리이길이 맞추기 위해 0 추가
                    else {
                        bridge.offer(0);
                        time++;
                    }

                }
            }
        }



        return time + bridge_length;
    }

    public static void main(String[] args) throws Exception{
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }

}
