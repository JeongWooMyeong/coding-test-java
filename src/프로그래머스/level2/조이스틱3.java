package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 조이스틱3 {

    public static int solution(String name){
        int answer = 0;
        int len = name.length();

        //알파벳 변경 고려
        for(int i=0;i<len;i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
        }

        //좌우 이동 고려
        int move = len - 1; //앞으로만 이동했을때 경우
        for(int i=0;i<len-1;i++){   //next 고려했을때 len-2 까ㅣ 해야 구할 수 있음
            int next = i+1;
            //원래 시작은 A를 둔상태에서 시작했으니
            //주어진 name에 A가 있으면 바꿀 필요 없음
            while(next < len && name.charAt(next) == 'A'){
                next++;
            }

            move = Math.min(move, i + len - next + Math.min(i, len-next));

        }

        answer += move;

        return answer;
    }

    public static void main(String[] args) throws Exception{
        String name = "JAN";
        System.out.println(solution(name));
    }

}
