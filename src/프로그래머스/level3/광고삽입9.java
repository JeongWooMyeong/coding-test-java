package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 광고삽입9 {

    static long[] prefix;

    public static String solution(String play_time, String adv_time, String[] logs){
        int play = toSec(play_time);
        int adv = toSec(adv_time);

        prefix = new long[play+1];

        for(String log : logs){
            String[] arr = log.split("-");
            int start = toSec(arr[0]);
            int end = toSec(arr[1]);

            prefix[start] += 1;
            prefix[end] -= 1;

        }

        for(int i=1;i<=play;i++){
            prefix[i] += prefix[i-1];
        }

        for(int i=1;i<=play;i++){
            prefix[i] += prefix[i-1];
        }

        long max = prefix[adv-1];
        int startTime = 0;

        for(int i=adv;i<=play;i++){
            long value = prefix[i] - prefix[i-adv];
            if(max < value){
                max = value;
                startTime = i-adv+1;
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
