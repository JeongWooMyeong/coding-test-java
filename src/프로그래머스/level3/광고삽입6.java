package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 광고삽입6 {

    static long[] presum;

    public static String solution(String play_time, String adv_time, String[] logs){
        int play = toSec(play_time); //죠르디의 동영상 재생 시간 길이
        int adv = toSec(adv_time);   //광고 재생 시간

        presum = new long[play+2];

        for(String log : logs){
            String[] arr = log.split("-");
            int start = toSec(arr[0]);
            int end = toSec(arr[1]);

            presum[start] += 1;
            presum[end] -= 1;

        }
        //i초에 시청한 인원
        for(int i=1;i<=play;i++){
            presum[i] += presum[i-1];
        }
        //i초동안 시청한 인원
        for(int i=1;i<=play;i++){
            presum[i] += presum[i-1];
        }


        long max = presum[adv-1];
        int startTime = 0;

        for(int i=adv;i<=play;i++){
            long value = presum[i] - presum[i - adv];
            if(max < value){
                max = value;
                startTime = i - adv + 1;
            }
        }


        return toTime(startTime);
    }

    static int toSec(String time){
        String[] arr = time.split(":");
        int H = Integer.parseInt(arr[0]) * 3600;
        int M = Integer.parseInt(arr[1]) * 60;
        int S = Integer.parseInt(arr[2]);

        return H + M + S;
    }

    static String toTime(int time){
        int H = time / 3600;
        int M = (time % 3600) / 60;
        int S = time % 60;


        return String.format("%02d:%02d:%02d", H, M, S);
    }

    public static void main(String[] args) throws Exception{
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        System.out.println(solution(play_time, adv_time, logs));

    }

}
