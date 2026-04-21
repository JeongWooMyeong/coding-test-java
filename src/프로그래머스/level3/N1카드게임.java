package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class N1카드게임 {
    static int N;
    static int[] cardsArr;
    static int[][] dp;  //round, coin

    public static int solution(int coin, int[] cards){
        N = cards.length;   //카드 개수
        cardsArr = cards;    //전역으로 쓰기 위함
        dp = new int[N+1][coin+1];
        for(int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, new HashSet<>(), coin);
    }

    static int dfs(int round, Set<Integer> hand, int coin){
        if(round >= N / 2) return round;

        //이번 라운드에서 카드 2장 뽑기
        int left = cardsArr[round * 2];
        int right = cardsArr[round * 2 + 1];

        //손패 복사 후 추가
        Set<Integer> newHand = new HashSet<>(hand);
        newHand.add(left);
        newHand.add(right);

        int maxRound = round;

        //버리고 다음 라운드
        maxRound = Math.max(maxRound, dfs(round + 1, newHand, coin));

        //N+1 규칙에 맞게
        for(int a : newHand){
            int b = (N+1) - a;
            if(newHand.contains(b)){
                Set<Integer> nextHand = new HashSet<>(newHand);
                nextHand.remove(a);
                nextHand.remove(b);
                maxRound = Math.max(maxRound, dfs(round + 1, nextHand, coin));
            }
        }

        //코인 있을때
        if(coin > 0){
            for(int a : newHand){
                int b = (N+1) - a;
                if(!newHand.contains(b)){
                    Set<Integer> nextHand = new HashSet<>(newHand);
                    nextHand.remove(a);
                    maxRound = Math.max(maxRound, dfs(round + 1, nextHand, coin -1));
                }
            }
        }


        return maxRound;
    }

    public static void main(String[] args) throws Exception{
        int coin = 4;
        int[] cards = {3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4};

        System.out.println(solution(coin, cards));
    }

}
