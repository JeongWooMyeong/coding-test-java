package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 스킬트리4 {

    static int answer;
    static int prev;
    static boolean possible;

    public static int solution(String skill, String[] skill_trees){

        answer = 0;

        for(String tree : skill_trees){
            prev = -1;
            possible = true;
            boolean missing = false;

            for(char c : skill.toCharArray()){
                int idx = tree.indexOf(c);

                if(idx == -1) {
                    missing = true;
                    continue;
                }

                if(missing || idx < prev){
                    possible = false;
                    break;
                }

                prev = idx;
            }

            if(possible){
                answer++;
            }
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        String skill = "CBD";
        String[] skill_trees = {"BACDE","CBADF","AECB","BDA"};

        System.out.println(solution(skill, skill_trees));
    }

}
