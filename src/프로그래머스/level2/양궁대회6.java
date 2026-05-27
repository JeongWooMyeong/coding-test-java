package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 양궁대회6 {
    static int[] apeach;
    static int[] lion;
    static int[] answer;
    static int max;

    public static int[] solution(int n, int[] info){
        apeach = info.clone();
        lion = new int[11];
        answer = new int[11];
        max = Integer.MIN_VALUE;

        dfs(0, n);

        if(max <= 0) return new int[]{-1};

        return answer;

    }

    static void dfs(int idx, int arrows){
        if(idx == 11){
            if(arrows >= 0){
                lion[10] += arrows;
            }
            int diff = getScore(lion, apeach);

            if(diff > max){
                answer = lion.clone();
                max = diff;
            }else if(diff == max){
                if(match(lion, answer)){
                    answer = lion.clone();
                }
            }

            if(arrows >= 0){
                lion[10] -= arrows;
            }

            return;
        }

        if(apeach[idx]+1 <= arrows){
            int needs = apeach[idx] + 1;
            lion[idx] = needs;
            dfs(idx+1, arrows- needs);
            lion[idx] -= needs;

        }

        dfs(idx+1, arrows);

    }

    static int getScore(int[] lion, int[] apeach){
        int lionScore = 0;
        int apeachScore = 0;

        for(int i=0;i<11;i++){
            //둘다 쏘지 않았을때는 점수처리 안함
            if(lion[i] == 0 && apeach[i] == 0) continue;

            if(lion[i] > apeach[i]) lionScore += 10 - i;
            else apeachScore += 10 - i;
        }

        return lionScore - apeachScore;

    }

    static boolean match(int[] a, int[] b){
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
