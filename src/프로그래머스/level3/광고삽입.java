package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 광고삽입 {
    public static String solution(String play_time, String adv_time, String[] logs){
        String answer = "";

        int play = toSec(play_time);
        int adv = toSec(adv_time);
        long[] presum = new long[play+2];

        for(String log : logs){
            String[] gubun = log.split("-");
            int start = toSec(gubun[0]);
            int end = toSec(gubun[1]);

            presum[start] += 1;
            presum[end] -= 1;
        }

        //1차 누적합
        //i초에 몇 명 보는지
        for(int i=1;i<=play;i++){
            presum[i] += presum[i-1];
        }

        //2차 누적합 이걸 왜 해야하는지 아직도 이해 못함
        //0초 ~ i초까지 총 시청 시간
        for(int i=1;i<=play;i++){
            presum[i] += presum[i-1];
        }

        long max = presum[adv - 1];
        int startTime = 0;

        //슬라이딩 윈도우
        for(int i=adv;i<=play;i++){
            long current = presum[i] - presum[i-adv];

            if(current > max){
                max = current;
                startTime = i - adv + 1;
            }
        }

        return toTime(startTime);
    }

    static int toSec(String time){
        String[] times = time.split(":");
        int H1 = Integer.parseInt(times[0]) * 3600;
        int M1 = Integer.parseInt(times[1]) * 60;
        int S1 = Integer.parseInt(times[2]);
        return H1 + M1 + S1;
    }

    static String toTime(int time){
        //String H1 = String.valueOf((time / 3600));
        //String M1 = String.valueOf((time % 3600) / 60);
        //String S1 = String.valueOf((time % 3600) % 60);
        int H1 = time / 3600;
        int M1 = (time % 3600) / 60;
        int S1 = time % 60;

        //return H1 + ":" + M1 + ":" + S1;
        return String.format("%02d:%02d:%02d", H1, M1, S1);
    }

    public static void main(String[] args) throws Exception{
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        System.out.println(solution(play_time, adv_time, logs));

    }

}
