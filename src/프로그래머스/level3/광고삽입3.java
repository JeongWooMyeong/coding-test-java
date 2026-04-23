package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 광고삽입3 {

    public static String solution(String play_time, String adv_time, String[] logs){
        int play = toSec(play_time);    //전체시간
        int adv = toSec(adv_time);  //광고시간
        //시청한 인원수
        int[] presum = new int[play + 2];   //넉넉하게
        for(String l : logs){
            String[] times = l.split("-");
            int start = toSec(times[0]);
            int end = toSec(times[1]);

            presum[start] += 1; //시작 시점에 한명 추가
            presum[end] -= 1;   //종료 시점에 한명 빠짐
        }

        //1차 누적합 i초에 시청한 인원
        for(int i=1;i<=play;i++){
            presum[i] += presum[i-1];
        }

        //2차 누적합 i초동안 시청한 인원
        for(int i=1;i<=play;i++){
            presum[i] += presum[i-1];
        }

        //adv time 구하기
        int max = presum[adv - 1];  //광고시간 전까지
        int startTime = 0;  //공익 광고 시간 0초로 초기화

        for(int i=adv;i<=play;i++){
            int value = presum[i] - presum[i - adv];    //i-adv+1 초 (광고시작시간) 까지 시청한 인원
            if(max < value){
                max = value;
                //시작 시간은 end - start + 1 임
                startTime = i - adv + 1;
            }
        }

        return toTime(startTime);

    }

    static int toSec(String time){
        String[] times = time.split(":");
        int H = Integer.parseInt(times[0]) * 3600;
        int M = Integer.parseInt(times[1]) * 60;
        int S = Integer.parseInt(times[2]);

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
