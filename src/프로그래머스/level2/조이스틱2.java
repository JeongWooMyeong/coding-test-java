package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 조이스틱2 {

    public static int solution(String name){
        int answer = 0;
        int len = name.length();

        //알파벳 변경 고려
        for(int i=0;i<len;i++){
            answer += Math.min(name.charAt(i)- 'A', 'Z' - name.charAt(i) + 1);  //A에서 아래쪽으로 이동하면 Z로
        }

        //좌우 이동 고려
        int move = len - 1; //앞쪽으로만 이동

        for(int i=0;i<len-1;i++){
            int next = i+1;
            //찾는 문자열에 A가 있으면 초기가 A이므로 건너뜀
            while(next < len && name.charAt(next) == 'A'){
                next++;
            }
            //앞에서 갔다가 오는경우, 뒤에서 갔다가 오는 경우중으 ㅣ최소값
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
