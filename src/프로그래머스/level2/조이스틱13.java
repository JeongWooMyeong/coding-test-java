package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 조이스틱13 {

    public static int solution(String name){
        int len = name.length();
        int answer = 0;

        for(int i=0;i<len;i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
        }

        int move = len - 1;

        for(int i=0;i<len-1;i++){
            int next = i + 1;

            //A는 건너뛰어도 됌
            while(next < len && name.charAt(next) == 'A'){
                next++;
            }
            //오른쪽으로 갔다가 다시 돌아와서 왼쪽으로 돌아오는 경우
            int case1 = i * 2 + (len - next);
            int case2 = i + (len - next) * 2;

            move = Math.min(move, case1);
            move = Math.min(move, case2);

        }

        answer += move;

        return answer;


    }

    public static void main(String[] args) throws Exception{
        String name = "JEROEN";

        System.out.println(solution(name));
    }

}
