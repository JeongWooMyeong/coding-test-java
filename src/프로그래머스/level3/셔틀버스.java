package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 셔틀버스 {
    static int[] mintable;
    static int[] bus;

    public static String solution(int n, int t, int m, String[] timetable){
        mintable= new int[timetable.length];

        for(int i=0;i<timetable.length;i++){
            mintable[i] = toMin(timetable[i]);
        }

        Arrays.sort(mintable);
        int bustime = toMin("09:00");
        String answer = "";


        bus = new int[n];
        int idx = 0;
        for(int i=0;i<n;i++){
            int count = 0;
            while(idx < mintable.length && mintable[idx] <= bustime && count < m){
                idx++;
                count++;
            }

            if(i == n-1){
                if(count == m){
                    answer = toHHMM(mintable[idx-1] -1);
                }else{
                    answer = toHHMM(bustime);
                }
            }

            bustime += t;
        }

        return answer;

    }

    static int toMin(String time){
        String[] t = time.split(":");
        int H = Integer.parseInt(t[0]) * 60;
        int M = Integer.parseInt(t[1]);

        return H + M;
    }

    static String toHHMM(int times){
        String HH = "";
        String MM = "";
        int H = times / 60;
        int M = times % 60;

        if(H < 10){
            HH = "0" + (H + "");
        }else{
            HH = H + "";
        }
        if(M < 10){
            MM = "0" + (M + "");
        }else{
            MM = M + "";
        }

        return HH + ":" + MM;

    }

    public static void main(String[] args) throws Exception{
        int n = 1;
        int t = 1;
        int m = 5;

        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};

        System.out.println(solution(n,t,m,timetable));

    }

}
