package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
내가 푼 방식 말고 다른 방식
 */

public class 압축2 {
    static Map<String, Integer> dict;

    public static int[] solution(String msg){
        dict = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        //사전에 우선 있는 단어 담기
        for(char c = 'A';c<='Z';c++){
            dict.put(String.valueOf(c), c - 'A' + 1);
        }

        int idx = 0;
        while(idx < msg.length()){
            String w = "";
            int lastIndex = idx;
            //가장 긴 최장 문자열 찾기 (없으면 break)
            while(lastIndex < msg.length()){
                //인덱스 - end start <= idx < end
                String next = msg.substring(idx, lastIndex + 1);
                if(dict.containsKey(next)){
                    w = next;
                    lastIndex++;
                }else break;
            }
            //나온 최장문자열 w에 대한 인덱스 저장
            result.add(dict.get(w));

            //사전에 없는거 추가
            if(lastIndex < msg.length()){
                String newEntry = msg.substring(idx, lastIndex + 1);
                dict.put(newEntry, dict.size()+1);
            }
            //인덱스는 해당 사전있는거 추가한거 이후니 lengt +
            idx += w.length();



        }

        return result.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) throws Exception{
        String msg = "KAKAO";
        System.out.println(Arrays.toString(solution(msg)));
    }
}
