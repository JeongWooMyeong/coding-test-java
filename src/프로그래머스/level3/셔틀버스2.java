package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 셔틀버스2 {
    static int[] crew;

    public static String solution(int n, int t, int m, String[] timetable){
        crew = new int[timetable.length];

        Arrays.sort(timetable);

        for(int i=0;i<crew.length;i++){
            crew[i] = toMin(timetable[i]);
        }

        int bustime = toMin("09:00");
        int idx = 0;
        String answer = "";
        for(int i=0;i<n;i++){
            int count = 0;
            while(idx < crew.length && crew[idx] <= bustime && count < m){
                idx++;
                count++;
            }

            if(i == n-1){
                if(count == m){
                    answer = toHHMM(crew[idx-1] - 1);
                }else{
                    answer = toHHMM(bustime);
                }
            }

            bustime += t;

        }

        return answer;

    }

    static int toMin(String times){
        String[] t = times.split(":");
        int H = Integer.parseInt(t[0]) * 60;
        int M = Integer.parseInt(t[1]);

        return H + M;
    }

    /*static String toHHMM(int times){
        int H = times / 60;
        int M = times % 60;
        String HH = "";
        String MM = "";
        StringBuilder sb = new StringBuilder();
        if(H < 10){
            HH = "0" + H;
        }else{
            HH = String.valueOf(H);
        }

        if(M < 10){
            MM = "0" + M;
        }else{
            MM = String.valueOf(M);
        }

        return HH + ":" + MM;

    }*/

    static String toHHMM(int times){
        int H = times / 60;
        int M = times % 60;

        return String.format("%02d:%02d", H, M);

    }

    public static void main(String[] args) throws Exception{
        int n = 1;
        int t = 1;
        int m = 5;

        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};

        System.out.println(solution(n,t,m,timetable));

    }

}
