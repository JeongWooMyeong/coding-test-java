package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 주차요금계산7 {

    static int[] answer;
    static Map<Integer, Integer> intime;
    static Map<Integer, Integer> totaltime;

    public static int[] solution(int[] fees, String[] records){

        intime = new HashMap<>();
        totaltime = new HashMap<>();

        for(String r : records){
            String[] arr = r.split(" ");
            int time = toMin(arr[0]);
            int carNum = Integer.parseInt(arr[1]);
            String type = arr[2];

            if("IN".equals(type)){
                intime.put(carNum, time);
            }else{
                totaltime.put(carNum, totaltime.getOrDefault(carNum, 0) + time - intime.get(carNum));
                intime.remove(carNum);
            }

        }

        for(int carnum : intime.keySet()){
            totaltime.put(carnum, totaltime.getOrDefault(carnum, 0) + toMin("23:59") - intime.get(carnum));
        }

        List<Integer> carList = new ArrayList<>();
        for(int carnum : totaltime.keySet()){
            carList.add(carnum);
        }

        Collections.sort(carList);
        answer = new int[carList.size()];

        for(int i=0;i<carList.size();i++){
            int cartime = totaltime.get(carList.get(i));
            answer[i] = getFee(cartime, fees);
        }

        return answer;
    }

    static int toMin(String time){
        String[] arr = time.split(":");
        int H = Integer.parseInt(arr[0]) * 60;
        int M = Integer.parseInt(arr[1]);

        return H + M;
    }

    static int getFee(int totaltime, int[] fees){
        int basictime = fees[0];
        int basicfee = fees[1];
        int unittime = fees[2];
        int unitfee = fees[3];

        if(totaltime <= basictime) return basicfee;

        return basicfee + (int)Math.ceil((double)(totaltime - basictime) / unittime) * unitfee;


    }

    public static void main(String[] args) throws Exception{
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(Arrays.toString(solution(fees, records)));
    }

}
