package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 양궁대회14 {

    static int[] lion;
    static int[] apeach;
    static int max;
    static int[] answer;

    public static int[] solution(int n, int[] info){
        lion = new int[11];
        apeach = info.clone();

        max = Integer.MIN_VALUE;
        answer = new int[11];

        dfs(0, n);

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
            }else if(max == diff && match(lion, answer)){
                answer = lion.clone();
            }

            if(arrows > 0) lion[10] -= arrows;

            return;
        }

        if(apeach[idx] + 1 <= arrows){
            int need = apeach[idx] + 1;
            lion[idx] += need;
            dfs(idx +1 , arrows - need);
            lion[idx] -= need;
        }

        dfs(idx+1, arrows);

    }

    static int getDiff(int[] l, int[] a){
        int lionScore = 0;
        int apeachScore = 0;

        for(int i=0;i<11;i++){
            if(l[i] == 0 && a[i] == 0) continue;
            if(l[i] > a[i]) lionScore += 10 - i;
            else apeachScore += 10 - i;
        }

        return lionScore - apeachScore;
    }

    static boolean match(int[] l, int[] a){
        for(int i=10;i>=0;i--){
            if(l[i] != a[i]){
                return l[i] > a[i];
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
