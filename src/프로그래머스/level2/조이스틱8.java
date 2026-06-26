package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 조이스틱8 {

    public static int solution(String name){
        int answer = 0;
        int len = name.length();

        for(int i=0;i<name.length();i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
        }

        int move = len - 1;
        for(int i=0;i<len-1;i++){
            int next = i + 1;

            while(next < len && name.charAt(next) == 'A'){
                next++;
            }

            move = Math.min(move, i + (len - next) + Math.min(i, len-next));

        }

        answer += move;


        return answer;
    }

    public static void main(String[] args) throws Exception{
        String name = "JEROEN";
        System.out.println(solution(name));
    }

}
