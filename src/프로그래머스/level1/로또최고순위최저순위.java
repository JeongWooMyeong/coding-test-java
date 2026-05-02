package 프로그래머스.level1;

import java.util.*;
import java.io.*;

public class 로또최고순위최저순위 {
    static int maxRank = Integer.MIN_VALUE;
    static int minRank = Integer.MAX_VALUE;

    public static int[] solution(int[] lottos, int[] win_nums){
        int count = 0;
        int zeroCount = 0;

        for(int x : lottos){
            if(x == 0){
                zeroCount++;
            }else{
                for(int x2 : win_nums){
                    if(x == x2){
                        count++;
                    }
                }
            }
        }

        if(zeroCount >= 0){
            for(int i=zeroCount;i>=0;i--){
                maxRank = Math.max(maxRank, (count + i));
                minRank = Math.min(minRank, (count + i));
            }
        }

        System.out.println(maxRank + ":" + minRank);

        maxRank = getRank(maxRank);
        minRank = getRank(minRank);

        int[] answer = new int[2];

        answer[0] = maxRank;
        answer[1] = minRank;

        return answer;
    }

    static int getRank(int count){
        switch(count){
            case 6 : return 1;
            case 5 : return 2;
            case 4 : return 3;
            case 3 : return 4;
            case 2 : return 5;
            case 1 : return 6;
            case 0 : return 6;
            default : return 6;
        }
    }

    public static void main(String[] args) throws Exception{
        int[] lottos = {44,1,0,0,31,25};
        int[] win_nums = {31,10,45,1,6,19};

        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }

}
