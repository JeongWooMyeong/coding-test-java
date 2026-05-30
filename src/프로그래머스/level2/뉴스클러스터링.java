package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
이렇게 풀어봤는데 이렇게는 안풀리나보네..
주어진 원소의 횟수를 가지고 이용해야한다네?
X
 */

public class 뉴스클러스터링 {

    static List<String> commonList;     //교집합 리스트
    static List<String> plusList;       //합집합 리스트,
    static List<String> str1List;
    static List<String> str2List;

    public static int solution(String str1, String str2){
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        commonList = new ArrayList<>();
        plusList = new ArrayList<>();
        str1List = new ArrayList<>();
        str2List = new ArrayList<>();

        for(int i=0;i<str1.length()-1;i++){
            char current = str1.charAt(i);
            char next = str1.charAt(i+1);

            if(Character.isLetter(current) && Character.isLetter(next)){
                str1List.add(String.valueOf(current) + String.valueOf(next));
            }

        }

        for(int i=0;i<str2.length()-1;i++){
            char current = str2.charAt(i);
            char next = str2.charAt(i+1);

            if(Character.isLetter(current) && Character.isLetter(next)){
                str2List.add(String.valueOf(current) + String.valueOf(next));
            }

        }
        //교집합 넣기
        for(int i=0;i<str1List.size();i++){
            for(int j=0;j<str2List.size();j++){
                if(str1List.get(i).equals(str2List.get(j))){
                    if(!commonList.contains(str1List.get(i))){
                        commonList.add(str1List.get(i));
                    }
                }
            }
        }

        plusList.addAll(str1List);
        plusList.addAll(str2List);

        double percent = (double) commonList.size() / plusList.size();
        percent *= 65536;

        return (int) percent;


    }

    public static void main(String[] args) throws Exception{
        String str1 = "FRANCE";
        String str2 = "french";

        System.out.println(solution(str1, str2));
    }

}
