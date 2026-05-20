package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 조이스틱4 {

    public static int solution(String name){
        int answer = 0; //조이스틱 최소 횟수
        int len = name.length();

        //알파벳 변경 관련 생각
        for(int i=0;i<name.length();i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) +1);  //A에서 시작이므로 Z로 바로 바꾸려면 1 필요
        }

        //좌우 이동 고려
        int move = len - 1; //그냥 앞으로 이동하는 경우

        for(int i=0;i<len-1;i++){
            int next = i + 1;   //다음 이동
            //다음이 A이면 커서 있을필요 없으므로 이동
            while(next < len && name.charAt(next) == 'A'){
                next++;
            }
            //앞으로 이동했다 다시 뒤로 가는 경우, 뒤로 갔다 앞으로 오는 경우 생각
            move = Math.min(move, i + len-next + Math.min(i, len-next));

        }

        answer += move;

        return answer;

    }

    public static void main(String[] args) throws Exception{
        String name = "JEROEN";
        System.out.println(solution(name));
    }

}
