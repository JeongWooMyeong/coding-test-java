package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 양궁대회3 {
    static int[] lion;
    static int[] apeach;
    static int[] answer;
    static int max = Integer.MIN_VALUE;

    public static int[] solution(int n, int[] info){
        lion = new int[11];
        apeach = new int[11];
        answer = new int[11];

        apeach = info;

        dfs(0, n, lion, apeach);

        if(max <= 0) return new int[]{-1};

        return answer;
    }

    static void dfs(int idx, int arrows, int[] lion, int[] apeach){
        if(idx == 11){
            //화살 남았으면 마지막에 다 더하기 (남은 갯수 없어야함)
            if(arrows > 0) lion[10] += arrows;
            //라이언과 어피치 점수차이 구하기
            int diff = getScore(lion, apeach);

            if(diff > max){
                max = diff;
                answer = lion.clone();
            }else if(diff == max && max >= 0){
                if(isBetter(lion, answer)){
                    answer = lion.clone();
                }
            }

            //누적된 화살 다시 원래대로
            if(arrows > 0) lion[10] -= arrows;

            return;

        }


        //어피치 보다 많은 화살을 쏠때
        int need = apeach[idx] + 1;
        if(arrows >= need){
            lion[idx] = need;
            dfs(idx+1, arrows-need, lion, apeach);
            lion[idx] = 0;
        }

        //현재 화살 선택 안함
        dfs(idx+1, arrows, lion, apeach);

    }

    static int getScore(int[] lion, int[] apeach){
        int lionScore = 0;
        int apeachScore = 0;

        for(int i=0;i<=10;i++){
            //둘다 0 일때는 점수 얻을 수 없네..
            if(lion[i] == 0 && apeach[i] == 0) continue;

            if(lion[i] > apeach[i]){
                lionScore += (10 - i);
            }else{
                apeachScore += (10 - i);
            }
        }

        return lionScore - apeachScore;

    }

    static boolean isBetter(int[] lion, int[] max){
        for(int i=10;i>=0;i--){
            if(lion[i] != max[i]){
                return lion[i] > max[i];
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
