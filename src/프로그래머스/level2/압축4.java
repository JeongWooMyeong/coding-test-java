package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 압축4 {
    static Map<String, Integer> dict;
    static ArrayList<Integer> resultList;

    public static int[] solution(String msg){
        dict = new HashMap<>();
        resultList = new ArrayList<>();
        //A~Z까지 색인번호 생성
        for(char c='A';c<='Z';c++){
            dict.put(String.valueOf(c), c - 'A' + 1);
        }

        //msg String 돌면서 확인
        int idx = 0;    //msg index;
        while(idx < msg.length()){
            int lastidx = idx;
            String w = "";
            //lastidx
            while(lastidx < msg.length()){
                String next = msg.substring(idx, lastidx + 1);
                if(dict.containsKey(next)){
                    w = next;
                    lastidx++;
                }else{
                    break;
                }
            }

            resultList.add(dict.get(w));

            if(lastidx < msg.length()){
                String newEntry = msg.substring(idx, lastidx+1);
                dict.put(newEntry, dict.size()+1);
            }

            idx += w.length();

        }

        int[] answer = new int[resultList.size()];
        for(int i=0;i<resultList.size();i++){
            answer[i] = resultList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        System.out.println(Arrays.toString(solution(msg)));
    }

}
