package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 양궁대회13 {

    static int[] lion;
    static int[] apeach;
    static int[] answer;
    static int max;

    public static int[] solution(int n, int[] info){
        lion = new int[11];
        apeach = info.clone();

        max = Integer.MIN_VALUE;

        dfs(0,n);

        if(max <= 0) return new int[]{-1};

        return answer;

    }

    static void dfs(int idx, int arrows){

        if(idx == 11){
            if(arrows > 0) lion[10] += arrows;

            int diff = getDiff(lion, apeach);

            if(max < diff){
                max = diff;
                answer = lion.clone();
            }else if(max == diff && match(answer, lion)){
                answer = lion.clone();
            }

            if(arrows > 0) lion[10] -= arrows;

            return;
        }


        if(arrows >= apeach[idx] + 1){
            lion[idx] = apeach[idx] + 1;
            dfs(idx+1, arrows - (apeach[idx] + 1));
            lion[idx] -= apeach[idx] + 1;
        }

        dfs(idx+1, arrows);

    }

    static int getDiff(int[] lion, int[] apeach){
        int lionScore = 0;
        int apeachScore = 0;

        for(int i=0;i<11;i++){
            if(lion[i] == 0 && apeach[i] == 0) continue;
            if(lion[i] > apeach[i]) lionScore += 10 - i;
            else apeachScore += 10 - i;

        }

        return lionScore - apeachScore;
    }

    static boolean match(int[] answer, int [] lion){
        for(int i=10;i>=0;i--){
            if(answer[i] != lion[i]) {
                return answer[i] < lion[i];
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception{
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        System.out.println(Arrays.toString(solution(n, info)));
    }

}
