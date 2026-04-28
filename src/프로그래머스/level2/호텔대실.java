package 프로그래머스.level2;

import java.util.*;

public class 호텔대실 {

    public static int solution(String[][] book_time){
        int answer = 0;

        Arrays.sort(book_time, (a,b)->a[1].compareTo(b[1]));

        String room = "00:00";

        for(String[] s : book_time){
            if(toSec(room) < toSec(s[0])){
                room = s[1];
                answer++;
            }
        }


        return answer;
    }

    static int toSec(String room){
        String[] s = room.split(":");
        int H = Integer.parseInt(s[0]) * 3600;
        int M = Integer.parseInt(s[1]) * 60;

        return H+M;
    }

    public static void main(String[] args) throws Exception{
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        System.out.println(solution(book_time));
    }

}
