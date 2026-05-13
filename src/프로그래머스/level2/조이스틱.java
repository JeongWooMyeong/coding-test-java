package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 조이스틱 {

    public static int solution(String name){
        int answer = 0;
        int len = name.length();
        //위 아래에 대한 최소 회수 구하기
        for(int i=0;i<len;i++){
            answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
        }

        //이동에 대한 최소 회수
        int move = len - 1; //앞으로만 이동하는 경우
        for(int i=0;i<len-1;i++){
            int next = i + 1;
            while(next < len && name.charAt(next) == 'A'){
                next++;
            }
            //A를 만났을 경우 뒤로 가는 경우가 효율적일 수 있음 (더 짧음)
            move = Math.min(move, i + len - next + Math.min(i, len-next));


        }

        answer += move;



        return answer;


    }

    public static void main(String[] args) throws Exception{
        String name = "JEROEN";
        System.out.println(solution(name));
    }

}
