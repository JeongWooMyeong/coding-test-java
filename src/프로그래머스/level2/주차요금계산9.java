package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 주차요금계산9 {

    static Map<Integer, Integer> intime;
    static Map<Integer, Integer> totaltime;
    static int[] answer;
    static List<Integer> carList;

    public static int[] solution(int[] fees, String[] records){
        intime = new HashMap<>();
        totaltime = new HashMap<>();

        for(String r : records){
            String[] arr = r.split(" ");

            int sec = toSec(arr[0]);
            int carnum = Integer.parseInt(arr[1]);
            String cmd = arr[2];

            if("IN".equals(cmd)){
                intime.put(carnum, sec);
            }else{
                totaltime.put(carnum, totaltime.getOrDefault(carnum, 0) + sec - intime.get(carnum));
                intime.remove(carnum);
            }
        }

        for(int key : intime.keySet()){
            totaltime.put(key, totaltime.getOrDefault(key,0) + toSec("23:59") - intime.get(key));
        }

        carList = new ArrayList<>();

        for(int key : totaltime.keySet()){
            carList.add(key);
        }

        Collections.sort(carList);

        answer = new int[carList.size()];

        for(int i=0;i<carList.size();i++){
            answer[i] = getFee(fees, carList.get(i));
        }

        return answer;
    }

    static int toSec(String time){
        String[] arr = time.split(":");

        int H = Integer.parseInt(arr[0]) * 60;
        int M = Integer.parseInt(arr[1]);

        return H + M;
    }

    static int getFee(int[] fees, int carnum){
        int basicSec = fees[0];
        int basicFee = fees[1];
        int unitSec = fees[2];
        int unitFee = fees[3];

        int existstime = totaltime.get(carnum);

        if(existstime <= basicSec){
            return basicFee;
        }

        return basicFee + (int)Math.ceil((double)(existstime - basicSec) / unitSec) * unitFee;

    }

    public static void main(String[] args) throws Exception{
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(Arrays.toString(solution(fees, records)));
    }

}
