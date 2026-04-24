package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 압축 {
    static Map<String, Integer> dictionary = new HashMap<>();

    public static int[] solution(String msg){
        List<Integer> resultList = new ArrayList<>();
        //일단 주어진 영문 대문자 한글자 추가
        for(char c='A';c<='Z';c++){
            dictionary.put(c + "", (c - 'A')+1);
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int prev = 0;
        //idx 주어진 문자열 길이까지
        while(idx < msg.length()){
            //sb에 담음
            sb.append(msg.charAt(idx) + "");
            //만약 해당 키가 존재하면
            if(dictionary.containsKey(sb.toString())){
                //이전값 저장 (그 이후에 더 있을 수 있으므로)
                prev = dictionary.get(sb.toString());
                //idx 증가
                idx++;
            }else{
                //다를때 이전값 저장
                resultList.add(prev);
                //그리고 dictionary map에 새로운 경우 추가
                dictionary.put(sb.toString(), dictionary.size()+1);
                //idx는 계속 증가하고 있고 다음 문자열 비교해야하므로 sb 초기화
                //sb = new StringBuilder();
                sb.setLength(0);
                //idx++;
            }
        }

        resultList.add(prev);

        int[] answer = new int[resultList.size()];
        for(int i=0;i<resultList.size();i++){
            answer[i] = resultList.get(i);
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        String msg = "KAKAO";
        System.out.println(Arrays.toString(solution(msg)));
    }

}
