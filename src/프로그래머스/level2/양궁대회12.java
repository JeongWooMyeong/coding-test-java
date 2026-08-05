package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 양궁대회12 {

    static int[] lion;
    static int[] apeach;
    static int[] answer;
    static int maxValue;

    public static int[] solution(int n, int[] info){
        maxValue = Integer.MIN_VALUE;

        apeach = info.clone();
        lion = new int[11];
        answer = new int[11];

        dfs(0,n);

        if(maxValue <= 0) return new int[]{-1};

        return answer;

    }

    static void dfs(int idx, int arrows){

        if(idx == 10){

            if(arrows > 0) lion[idx] += arrows;

            int diff = getDiff(lion, apeach);

            if(maxValue < diff){
                maxValue = diff;
                answer = lion.clone();
            }else if(maxValue == diff && match(lion,answer)){
                answer = lion.clone();
            }

            if(arrows > 0) lion[idx] -= arrows;

            return;
        }


        if(apeach[idx] + 1 <= arrows){
            int need = apeach[idx] + 1;
            lion[idx] += need;
            dfs(idx+1, arrows - need);
            lion[idx] -= need;
        }

        dfs(idx+1, arrows);

    }

    static int getDiff(int[] lion, int[] apeach){
        int lionCount = 0;
        int apeachCount = 0;

        for(int i=0;i<lion.length;i++){
            if(lion[i] == 0 && apeach[i] == 0) continue;
            if(lion[i] > apeach[i]){
                lionCount += 10 - i;
            }else{
                apeachCount += 10 - i;
            }
        }

        return lionCount - apeachCount;

    }

    static boolean match(int[] lion, int[] answer){
        for(int i=10;i>=0;i--){
            if(lion[i] != answer[i]){
                return lion[i] > answer[i];
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
