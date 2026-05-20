package 프로그래머스.level1;

import java.util.*;
import java.io.*;

public class 다트게임 {
    static int[] results;

    public static int solution(String dartResult){
        int idx = 0;
        char[] c = dartResult.toCharArray();
        List<Integer> numList = new ArrayList<>();
        int answer = 0;

        for(int i=0;i<c.length;i++){
            if(Character.isDigit(c[i])){
                if(i > 0 && Character.isDigit(c[i-1])) continue;
                numList.add(i);
            }
        }

        results = new int[numList.size()];

        for(int i=0;i<numList.size()-1;i++){
            int next = numList.get(i + 1);
            String chance = dartResult.substring(numList.get(i), next);
            results[i] = getScore(chance, i);
        }
        //맞네 마지막 계산 안했네..
        results[numList.size()-1] =
                getScore(
                        dartResult.substring(numList.get(numList.size()-1)),
                        numList.size()-1
                );

        for(int x : results){
            answer += x;
        }

        return answer;

    }

    static int getScore(String chance, int num){
        char[] c = chance.toCharArray();
        int score;
        char bonus;
        char option;
        double total = 0;

        if(c[0] == '1' && c[1] == '0'){
            score = Integer.parseInt(chance.substring(0, 2)); // 올바른 처리
            bonus = c[2];
        } else {
            score = Integer.parseInt(String.valueOf(c[0]));
            bonus = c[1];
        }

        if(bonus == 'S'){
            total = Math.pow(score, 1);
        }else if(bonus == 'D'){
            total = Math.pow(score, 2);
        }else{
            total = Math.pow(score, 3);
        }


        char last = c[c.length - 1];

        if(last == '*' || last == '#'){
            option = last;

            if(option == '#'){
                total *= -1;
            }else{
                total *= 2;
                if(num != 0){
                    results[num-1] *= 2;
                }
            }

        }

        return (int) total;
    }

    public static void main(String[] args) throws Exception{
        String dartResult = "1S2D*3T";
        System.out.println(solution(dartResult));
    }

}
