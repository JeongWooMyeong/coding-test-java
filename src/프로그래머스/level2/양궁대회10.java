package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 양궁대회10 {
    static int[] answer;
    static int[] lion;
    static int[] apeach;
    static int maxValue;

    public static int[] solution(int n, int[] info){
        answer = new int[11];

        apeach = info.clone();
        lion = new int[11];
        maxValue = Integer.MIN_VALUE;

        dfs(0, n);

        if(maxValue <= 0) return new int[]{-1};


        return answer;
    }

    static void dfs(int idx, int arrows){
        if(idx == 11){
            if(arrows > 0) lion[10] += arrows;

            int diff = getCount(lion, apeach);

            if(diff > maxValue){
                maxValue = diff;
                answer = lion.clone();
            }else if(diff == maxValue && match(lion, answer)){
                answer = lion.clone();
            }

            if(arrows > 0) lion[10] -= arrows;


            return;
        }

        //화살을 더 많이 쏠 경우
        if(apeach[idx] + 1 <= arrows){
            int needs = apeach[idx] + 1;
            lion[idx] += needs;
            dfs(idx+1, arrows-needs);
            lion[idx] -= needs;
        }


        dfs(idx+1, arrows);

    }

    static int getCount(int[] lion, int[] apeach){
        int lionScore = 0;
        int apeachScore = 0;

        for(int i=0;i<lion.length;i++){
            if(lion[i] == 0 && apeach[i] == 0) continue;
            if(lion[i] > apeach[i]) lionScore += 10 - i;
            else apeachScore += 10 - i;

        }

        return lionScore - apeachScore;
    }

    static boolean match(int[] lion, int[] answer){
        for(int i=10;i>=0;i--){
            if(lion[i] != answer[i]) return lion[i] > answer[i];
        }

        return false;
    }

    public static void main(String[] args) throws Exception{
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        System.out.println(Arrays.toString(solution(n, info)));
    }

}
