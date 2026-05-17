package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 양궁대회5 {
    static int[] apeach;
    static int[] lion;
    static int maxValue;
    static int[] answer;

    public static int[] solution(int n, int[] info){
        apeach = info.clone();
        lion = new int[11];
        answer = new int[11];
        maxValue = Integer.MIN_VALUE;

        dfs(0,n);

        if(maxValue <= 0) return new int[]{-1};

        return answer;

    }

    static void dfs(int idx, int arrows){
        if(idx == 11){
            //화살 남은거 있을때 다 써야하므로 마지막 화살에 다 넣음
            if(arrows >= 0) lion[10] += arrows;

            int diff = getScore(lion, apeach);
            if(maxValue < diff){
                maxValue = diff;
                answer = lion.clone();
            //같은 경우 가장 낮은 점수를 더 많이 맞힌 경우
            }else if(maxValue == diff){
                if(match(answer, lion)){
                    answer = lion.clone();
                }
            }


            //원상복구
            if(arrows >= 0) lion[10] -= arrows;

            return;
        }

        //화살을 어피치보다 많이 쏘는 경우
        int need = apeach[idx] + 1;
        if(arrows >= need){
            lion[idx] = need;
            dfs(idx+1, arrows - need);
            lion[idx] -= need;
        }

        //화살 안쏘는 경우
        dfs(idx+1, arrows);

    }

    static int getScore(int[] lion, int[] apeach){
        int lionscore = 0;
        int apeachscore = 0;

        for(int i=0;i<11;i++){
            //아 이조건 빼먹었네 .. 둘다 0이면 점수 계산 안해야하는데...
            //if(lion[i] == 0 && apeach[i] == 0) continue;

            if(lion[i] > apeach[i]) lionscore += 10 - i;
            else if(apeach[i] > 0) apeachscore += 10 - i;
        }

        return lionscore - apeachscore;

    }
    //diff == maxValue 같을때 가장 낮은 점수 확인하는 방법
    static boolean match(int[] exists, int[] lion){
        for(int i=10;i>=0;i--){
            if(exists[i] != lion[i]){
                return exists[i] < lion[i];
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
