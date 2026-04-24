package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 주차요금계산2 {

    public static int[] solution(int[] fees, String[] records){
        Map<Integer, Integer> intime = new HashMap<>();
        Map<Integer, Integer> totalTime = new HashMap<>();

        for(String r : records){
            String[] record = r.split(" ");
            String[] times = record[0].split(":");
            int sec = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            int car = Integer.parseInt(record[1]);
            String type = record[2];

            if("IN".equals(type)){
                intime.put(car, sec);
            }else{
                totalTime.put(car, totalTime.getOrDefault(car, 0) + (sec - (intime.get(car))));
                intime.remove(car);
            }

        }
        //intime에 아직 남아있단 이야기는 out 시간을 못정함
        for(int car : intime.keySet()){
            int sec = (23 * 60) + 59;
            totalTime.put(car, totalTime.getOrDefault(car, 0) + (sec - (intime.get(car))));
        }

        List<Integer> cars = new ArrayList<>(totalTime.keySet());
        Collections.sort(cars);

        int[] answer = new int[cars.size()];
        for(int i=0;i<cars.size();i++){
            answer[i] = getPay(totalTime.get(cars.get(i)), fees);
        }

        return answer;

    }

    static int getPay(int sec, int[] fees){
        int basicsec = fees[0];
        int basicfee = fees[1];
        int unitsec = fees[2];
        int unitfee = fees[3];

        int result = 0;

        if(sec > basicsec){
            result = basicfee + (int) Math.ceil((double)(sec - basicsec) / unitsec) * unitfee;
        }else{
            result = basicfee;
        }

        return result;
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
