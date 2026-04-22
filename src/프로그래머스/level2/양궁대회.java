package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 양궁대회 {
    static int[] lion = new int[11];
    static int maxDiff = -1;
    static int[] answer = new int[11];

    public static int[] solution(int n, int[] info){
        dfs(0, n, info, lion);

        //라이언이 이길 수 없는 경우
        if(maxDiff <= 0){
            return new int[]{-1};
        }

        return answer;
    }

    static void dfs(int idx, int arrows, int[] apeach, int[] lion){
        if(idx == 11){
            //남은 화살 더하기
            lion[10] += arrows;

            int diff = getScore(lion, apeach);
            if(maxDiff < diff){
                maxDiff = diff;
                answer = lion.clone();
            }else if(diff == maxDiff && diff > 0){
                if(isBetter(lion, answer)){
                    answer = lion.clone();
                }
            }

            lion[10] -= arrows;
            return;
        }

        //어피치보다 많이 쏠 경우
        int need = apeach[idx];
        if(need + 1 <= arrows){
            lion[idx] = need + 1;
            dfs(idx+1, arrows-(need+1), apeach, lion);
            lion[idx] = 0;
        }
        //안쏠경우
        dfs(idx+1, arrows, apeach, lion);

    }

    static int getScore(int[] lion, int[] apeach){
        int apeachScore = 0;
        int lionScore = 0;

        for(int i=0;i<10;i++){
            //같을때 처리
            if(apeach[i] == 0 && lion[i] == 0) continue;

            if(apeach[i] < lion[i]){
                lionScore += (10 - i);
            }else{
                apeachScore += (10 - i);
            }
        }

        return lionScore - apeachScore;
    }
    //차이가 같으면 낮은 점수 많이 맞춘 순으로
    static boolean isBetter(int[] lion, int[] apeach){

        for(int i=9;i>=0;i--){
            if(apeach[i] != lion[i]){
                return lion[i] > apeach[i];
            }
        }

        return false;

    }

    public static void main(String[] args) throws Exception{
        int n = 1;
        //int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        int[] info = 	{1,0,0,0,0,0,0,0,0,0,0};
        System.out.println(Arrays.toString(solution(n, info)));
    }

}
