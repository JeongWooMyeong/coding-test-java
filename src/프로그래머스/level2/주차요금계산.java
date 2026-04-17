package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 주차요금계산 {
    public static int[] solution(int[] fees, String[] records){
        Map<String, Integer> totalTime = new HashMap<>();
        Map<String, Integer> inTime = new HashMap<>();

        for(String record : records){
            String[] rec = record.split(" ");
            int time = toMinute(rec[0]);
            String car = rec[1];
            String type = rec[2];

            if("IN".equals(type)){
                inTime.put(car, time);
            }else{
                int start = inTime.remove(car);
                totalTime.put(car, totalTime.getOrDefault(car,0) + (time - start));
            }
        }

        //출차 기록 없는 차량 체크
        for(String car : inTime.keySet()){
            int start = inTime.get(car);
            totalTime.put(car, totalTime.getOrDefault(car, 0) + (toMinute("23:59") - start));
        }

        //차량 번호 오름차순 정렬 후 요금 계산
        List<String> cars = new ArrayList<>(totalTime.keySet());
        Collections.sort(cars);

        int[] answer = new int[cars.size()];
        for(int i=0;i<cars.size();i++){
            answer[i] = calcFee(totalTime.get(cars.get(i)), fees);
        }

        return answer;
    }

    static int toMinute(String time){
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    static int calcFee(int time, int[] fees){
        int basetime = fees[0];
        int basefee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];


        if(time <= basetime) return basefee;
        //정수 나눗셈 피하기 위해 unittime double형
        return basefee + (int)Math.ceil((time - basetime) / (double) unitTime) * unitFee;

    }

    public static void main(String[] args) throws Exception{
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        int[] result = solution(fees, records);
        StringBuilder sb = new StringBuilder();

        for(int x : result){
            sb.append(x).append("\n");
        }
        System.out.println(sb.toString());

//        System.out.println(solution(fees, records));
    }

}
