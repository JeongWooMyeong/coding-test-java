package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 스킬트리2 {

    public static int solution(String skill, String[] skill_trees){
        char[] c = skill.toCharArray();
        int answer = 0;

        for(String sk : skill_trees){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<sk.length();i++){
                for(char c1 : c){
                    if(sk.charAt(i) == c1){
                        sb.append(c1);
                    }
                }
            }

            String str = sb.toString();

            if(skill.startsWith(str)) answer++;

        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(solution(skill, skill_trees));
    }

}
