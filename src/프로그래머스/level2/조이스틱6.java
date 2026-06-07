package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 조이스틱6 {

    public static int solution(String name){
        char[] c = name.toCharArray();
        int len = c.length;
        int answer = 0;
        //알파벳 변경 횟수
        for(int i=0;i<c.length;i++){
            answer += Math.min(c[i] - 'A', 'Z' - c[i] + 1);
        }

        //커서 이동 확인
        int move = len - 1;
        for(int i=0;i<len;i++){
            int next = i+1;
            while(next < len && c[next] == 'A'){
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
