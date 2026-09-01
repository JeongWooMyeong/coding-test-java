package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 스킬트리3 {

    public static int solution(String skill, String[] skill_trees){
        int answer = 0;

        for(String tree : skill_trees){
            int prev = -1;
            boolean possible = true;

            for(char c : skill.toCharArray()){
                int idx = tree.indexOf(c);

                if(idx == -1) continue;

                if(idx < prev){
                    possible = false;
                    break;
                }

                prev = idx;

            }

            if(possible) answer++;

        }
        return answer;
    }

}
