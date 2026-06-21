package 프로그래머스.level2;

import java.util.Arrays;

public class 양궁대회7 {

    static int[] lion;
    static int[] apeach;
    static int[] answer;
    static int max = Integer.MIN_VALUE;

    public static int[] solution(int n, int[] info){
        lion = new int[11];
        answer = new int[11];
        apeach = info.clone();

        dfs(0, n);

        if(max <= 0) return new int[]{-1};

        return answer;
    }

    static void dfs(int idx, int arrows){

        if(idx == 11){
            if(arrows > 0) lion[10] += arrows;
            int diff = getScore(lion, apeach);
            if(max < diff){
                max = diff;
                answer = lion.clone();
            }else if(max == diff){
                if(match(lion, answer)){
                    answer = lion.clone();
                }
            }
            lion[10] -= arrows;
            return;
        }


        //라이언이 어피치보다 많이 쏠 경우
        if(apeach[idx] + 1 <= arrows){
            int needs = apeach[idx] + 1;
            lion[idx] = needs;
            dfs(idx+1, arrows - needs);
            lion[idx] -= needs;
        }

        //안쏠 경우
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
