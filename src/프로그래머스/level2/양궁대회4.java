package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 양궁대회4
{
    static int[] lion;
    static int[] apeach;
    static int max = Integer.MIN_VALUE;
    static int[] answer;

    public static int[] solution(int n, int[] info){
        lion = new int[11];
        apeach = info;
        answer = new int[11];

        dfs(0, n, lion, apeach);

        if(max <= 0) return new int[]{-1};

        return answer;

    }

    static void dfs(int idx, int arrows, int[] lion, int[] apeach){
        if(idx == 11){
            //남은 화살 누적
            if(arrows >= 0) lion[10] += arrows;
            //차이 구하기
            int diff = getDiff(lion, apeach);
            if(diff > max){
                max = diff;
                answer = lion.clone();
            }else if(diff == max && diff >=0){
                //구한 차이 점수와 최대값이 같으면 작은 값이 많은걸 확인
                //이거 apeach가 아니라 answer (현재 max) 비교
                if(isBetter(lion, answer)){
                    answer = lion.clone();
                }
            }

            //누적 시킨 화살 다시 복구 (백트래킹 때문에)
            if(arrows >= 0) lion[10] -= arrows;


            return;
        }

        int need = apeach[idx] + 1;
        //라이언이 어피치보다 많이 쏠때
        if(arrows >= need){
            lion[idx] = need;
            dfs(idx + 1, arrows - need, lion, apeach);
            lion[idx] = 0;
        }

        //라이언이 안쏠대
        dfs(idx + 1, arrows, lion, apeach);

    }

    static int getDiff(int[] lion, int[] apeach){
        int lionScore = 0;
        int apeachScore = 0;

        for(int i=0;i<lion.length;i++){
            //이거 둘다 0발 쏠 경우 제외 해야함
            if(lion[i] == 0 && apeach[i] == 0) continue;

            if(lion[i] > apeach[i]) lionScore += (10 - i);
            else if(lion[i] < apeach[i]) apeachScore += (10 - i);
        }

        return lionScore - apeachScore;
    }

    static boolean isBetter(int[] lion, int[] best){
        for(int i=10;i>=0;i--){
            if(lion[i] != best[i]){
                return lion[i] > best[i];
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
