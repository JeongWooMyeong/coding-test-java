package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 광고삽입2 {
    public static String solution(String play_time, String adv_time, String[] logs){
        String answer = "";

        //1. 현재 String으로는 비교 불가 그리고 배열에 담을 수 없으므로 담을 수 있는 초로 변경
        int playtime = toSec(play_time);
        int advtime = toSec(adv_time);

        long[] presum = new long[playtime + 2];

        //2. logs 광고들도 초로 변환 및 시작일때 광고 1명 추가 끝일때 광고 한명 안봄
        for(String log : logs){
            //시작 끝 시간 같이 나옴 (시작, 끝 나눔
            String[] times = log.split("-");
            //시작 끝 시간 초로 바꿈
            int start = toSec(times[0]);
            int end = toSec(times[1]);
            //시작시점에는 시청자가 한명 들어감
            presum[start] += 1;
            //광고가 종료되면 사라짐
            presum[end] -= 1;

        }

        //1차 누적함 i초에 몇명 시청했는지
        for(int i=1;i<=playtime;i++){
            presum[i] += presum[i-1];
        }

        //2차 누적합 (몇초동안 시청했는지 ?
        for(int i=1;i<=playtime;i++){
            presum[i] += presum[i-1];
        }

        //adv time 구하기
        //max는 광고 시간 이전까지의 누적합
        long max = presum[advtime - 1];
        int startTime = 0;
        //슬라이딩 윈도우
        for(int i=advtime;i<=playtime;i++){
            //i -advtime + 1초부터 i초까지의 총 시청 시간
            long value = presum[i] - presum[i - advtime];
            if(max < value){
                max = value;
                startTime = i - advtime + 1;
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
        int M = (time%3600) / 60;
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
