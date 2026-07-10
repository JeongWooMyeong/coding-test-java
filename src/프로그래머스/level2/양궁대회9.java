package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 양궁대회9 {

    static int[] lion;
    static int[] apeach;
    static int[] answer;
    static int maxValue;

    public static int[] solution(int n, int[] info){
        maxValue = Integer.MIN_VALUE;

        apeach = info.clone();
        lion = new int[11];

        dfs(0,n);

        if(maxValue <= 0) return new int[]{-1};


        return answer;
    }

    static void dfs(int idx, int arrows){
        if(idx == 11){

            if(arrows > 0) lion[10] += arrows;

            int diff = getScore(lion, apeach);

            if(diff > maxValue){
                maxValue = diff;
                answer = lion.clone();
            }else if(diff == maxValue){
                if(match(lion, answer)){
                    answer = lion.clone();
                }
            }

            if(arrows > 0) lion[10] -= arrows;

            return;
        }

        int needs = apeach[idx] + 1;
        if(needs <= arrows){
            lion[idx] = needs;
            dfs(idx+1, arrows - apeach[idx] - 1);
            lion[idx] -= needs;
        }

        dfs(idx+1, arrows);

    }

    static int getScore(int[] lion, int[] apeach){
        int lionScore = 0;
        int apeachScore = 0;

        for(int i=0;i<lion.length;i++){
            if(lion[i] == 0 && apeach[i] == 0) continue;
            if(lion[i] > apeach[i]) lionScore += 10 - i;
            else apeachScore += 10 - i;
        }


        return lionScore - apeachScore;
    }

    static boolean match(int[] a, int[] b){
        if(a.length != b.length) return false;

        for(int i=10;i>=0;i--){
            if(a[i] != b[i]){
                return a[i] > b[i];
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
