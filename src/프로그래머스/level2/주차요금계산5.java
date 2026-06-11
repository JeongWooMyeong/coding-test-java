package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 주차요금계산5 {

    static Map<Integer, Integer> intime;
    static Map<Integer, Integer> totaltime;

    public static int[] solution(int[] fees, String[] records){
        intime = new HashMap<>();
        totaltime = new HashMap<>();

        for(String r : records){
            String[] arr = r.split(" ");
            int time = toMin(arr[0]);
            int carnum = Integer.parseInt(arr[1]);
            String type = arr[2];

            if("IN".equals(type)){
                intime.put(carnum, time);
            }else{
                totaltime.put(carnum, totaltime.getOrDefault(carnum, 0) + time - intime.get(carnum));
                intime.remove(carnum);
            }

        }

        for(int num : intime.keySet()){
            totaltime.put(num, totaltime.getOrDefault(num, 0) + toMin("23:59") - intime.get(num));
        }

        List<Integer> carList = new ArrayList<>(totaltime.keySet());
        Collections.sort(carList);

        int[] answer = new int[carList.size()];
        for(int i=0;i<carList.size();i++){
            answer[i] = getFee(totaltime.get(carList.get(i)), fees);
        }


        return answer;
    }

    static int toMin(String time){
        String[] arr = time.split(":");
        int H = Integer.parseInt(arr[0]) * 60;
        int M = Integer.parseInt(arr[1]);

        return H + M;
    }

    static int getFee(int min, int[] fees){
        int basictime = fees[0];
        int basicfee = fees[1];
        int unittime = fees[2];
        int unitfee = fees[3];

        if(min <= basictime) return basicfee;

        return basicfee + (int)Math.ceil((double)(min - basictime) / unittime) * unitfee;
    }

    public static void main(String[] args) throws Exception{
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(Arrays.toString(solution(fees, records)));
    }

}
