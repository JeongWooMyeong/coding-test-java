package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class N1카드게임8 {

    static Set<Integer> hand;
    static Set<Integer> draw;
    static int n;

    public static int solution(int coin, int[] cards){
        n = cards.length;
        hand = new HashSet<>();
        draw = new HashSet<>();
        //카드 받기
        int idx = n / 3;
        for(int i=0;i<idx;i++){
            hand.add(cards[i]);
        }

        int target = n + 1;
        int round = 1;
        while(true){

            if(hand.isEmpty()) break;

            if(idx < n) draw.add(cards[idx++]);
            if(idx < n) draw.add(cards[idx++]);

            boolean found = false;

            int removeA = 0;
            int removeB = 0;
            //내 손패에서 처리 가능한 경우
            for(int a : hand){
                int b = target - a;
                if(hand.contains(b)){
                    removeA = a;
                    removeB = b;
                    found = true;
                    break;
                }
            }

            if(found){
                hand.remove(removeA);
                hand.remove(removeB);
                round++;
                continue;
            }

            //코인 하나 사용해서 진행
            if(coin > 0){
                for(int a : hand){
                    int b = target-a;
                    if(draw.contains(b)){
                        removeA = a;
                        removeB = b;
                        coin -= 1;
                        found = true;
                        break;
                    }
                }

                if(found){
                    hand.remove(removeA);
                    draw.remove(removeB);
                    round++;
                    continue;
                }

            }

            //코인 2개 사용
            if(coin > 1){
                for(int a : draw){
                    int b = target-a;
                    if(draw.contains(b)){
                        removeA = a;
                        removeB = b;
                        found = true;
                        coin -= 2;
                        break;
                    }
                }

                if(found){
                    draw.remove(removeA);
                    draw.remove(removeB);
                    round++;
                    continue;
                }

            }

            //3가지 방법 안되면 종료
            break;


        }

        return round;
    }

    public static void main(String[] args) throws Exception{
        int coin = 4;
        int[] cards = {3,6,7,2,1,10,5,9,8,12,11,4};

        System.out.println(solution(coin, cards));
    }

}
