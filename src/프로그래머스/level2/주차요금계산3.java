package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 주차요금계산3 {
    static Map<Integer, Integer> inTime;
    static Map<Integer, Integer> totalTime;

    public static int[] solution(int[] fees, String[] records){
        inTime = new HashMap<>();
        totalTime = new HashMap<>();

        //입 출차 기록 누적시간 계산
        for(String r: records){
            String[] record = r.split(" ");
            int time = toMin(record[0]);
            int car = Integer.parseInt(record[1]);
            String type = record[2];

            if("IN".equals(type)){
                inTime.put(car, time);
            }else{
                totalTime.put(car, totalTime.getOrDefault(car, 0) + (time - inTime.get(car)));
                //계산후 입차한 차량 제거
                inTime.remove(car);
            }

        }

        //나머지 있는 시간에 대해서 누적 총합 구하기
        for(int key : inTime.keySet()){
            int time = toMin("23:59");
            totalTime.put(key, totalTime.getOrDefault(key, 0) + (time - inTime.get(key)));
        }

        List<Integer> carList = new ArrayList<>(totalTime.keySet());
        Collections.sort(carList);

        int[] answer = new int[carList.size()];

        for(int i=0;i<carList.size();i++){
            int time = totalTime.get(carList.get(i));
            answer[i] = getPay(time, fees);
        }


        return answer;
    }


    static int toMin(String time){
        String[] times = time.split(":");
        int H = Integer.parseInt(times[0]) * 60;
        int M = Integer.parseInt(times[1]);

        return H + M;
    }

    static int getPay(int time, int[] fees){
        int basictime = fees[0];
        int basicfee = fees[1];
        int unittime = fees[2];
        int unitfee = fees[3];

        if(time <= basictime){
            return basicfee;
        }

        int pay = basicfee + (int)Math.ceil((double)(time - basictime) / unittime) * unitfee;

        return pay;

    }

    public static void main(String[] args) throws Exception{
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(Arrays.toString(solution(fees, records)));
    }

}
