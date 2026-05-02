package 프로그래머스.level1;

import java.util.*;
import java.io.*;

public class 로또최고순위최저순위2 {
    static int maxCount = Integer.MIN_VALUE;
    static int minCount = Integer.MAX_VALUE;

    public static int[] solution(int[] lottos, int[] win_nums){
        int zeroCount = 0;
        int count = 0;

        for(int x : lottos){
            if(x == 0){
                zeroCount++;
            }else{
                for(int x2 : win_nums){
                    if(x == x2) count++;
                }
            }
        }

        maxCount = count + zeroCount;
        minCount = count;

        int maxRank = getRank(maxCount);
        int minRank = getRank(minCount);

        int[] answer = new int[2];

        answer[0] = maxRank;
        answer[1] = minRank;

        return answer;
    }

    static int getRank(int count){
        return count < 2 ? 6 : 7 - count;
    }

    public static void main(String[] args) throws Exception{
        int[] lottos = {44,1,0,0,31,25};
        int[] win_nums = {31,10,45,1,6,19};

        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }

}
