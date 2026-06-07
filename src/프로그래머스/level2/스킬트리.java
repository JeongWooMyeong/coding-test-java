package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 스킬트리 {

    public static int solution(String skill, String[] skill_trees){
        int answer = 0;

        char[] c = skill.toCharArray();

        for(String sk : skill_trees){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<sk.length();i++){
                char c1 = sk.charAt(i);
                for(char c2 : c){
                    if(c1 == c2){
                        sb.append(c2);
                    }
                }

            }

            String sk2 = sb.toString();

            if(skill.startsWith(sk2)) answer++;


        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(solution(skill, skill_trees));
    }

}
