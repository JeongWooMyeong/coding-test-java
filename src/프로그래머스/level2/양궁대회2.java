package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 양궁대회2 {
    static int[] lion = new int[11];
    static int[] answer = new int[11];
    static int maxDiff = -1;

    public static int[] solution(int n, int[] info){

        dfs(0, n, lion, info);

        if(maxDiff <= 0) return new int[]{-1};

        return answer;
    }

    static void dfs(int idx, int arrows, int[] lion, int[] apeach){
        if(idx == 11){
            //화살 모두 다 써야함
            if(arrows > 0) lion[10] += arrows;
            //라이언과 어피치의 양궁 점수 차이 구하기
            int diff = getScore(lion, apeach);
            //diff가 maxdiff보다 크다면 maxdiff 갱신
            if(diff > maxDiff){
                maxDiff = diff;
                answer = lion.clone();
            //만약 현재 maxdiff랑 diff 랑 같아면 낮은 점수를 많이 쓴걸로
            }else if(diff == maxDiff && maxDiff >= 0){
                //기존 answer와 비교해야함 (난 apeach로 씀..)
                if(isBetter(lion, answer)){
                    answer = lion.clone();
                }
            }
            //개수 복원
            if(arrows > 0) lion[10] -= arrows;
            return;

        }
        //어피치 보다 더 쏘는 경우 (득점)
        int need = apeach[idx] + 1;
        if(need <= arrows){
            lion[idx] = need;
            dfs(idx+1, arrows-need, lion, apeach);
            //복구
            lion[idx] = 0;
        }

        //안쏘는 경우
        dfs(idx+1, arrows, lion, apeach);


    }

    static int getScore(int[] lion, int[] apeach){
        int lscore = 0; //라이언 스코어
        int ascore = 0;// 어피치 스코어
        for(int i=0;i<11;i++){
            if(lion[i] == 0 && apeach[i] == 0) continue;
            if(lion[i] > apeach[i]){
                lscore += (10-i);
            }else{
                ascore += (10-i);
            }
        }

        return lscore - ascore;
    }
    //점수 차이가 같을 경우 낮은 점수 많이 쏜사람
    static boolean isBetter(int[] lion, int[] apeach){
        for(int i=10;i>=0;i--){
            if(lion[i] != apeach[i]){
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
