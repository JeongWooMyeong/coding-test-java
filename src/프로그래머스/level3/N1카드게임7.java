package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class N1카드게임7 {
    static Set<Integer> hand;
    static Set<Integer> draw;

    public static int solution(int coin, int[] cards){
        int n = cards.length;

        hand = new HashSet<>();
        draw = new HashSet<>();

        int idx = n / 3;

        for(int i=0;i<idx;i++){
            hand.add(cards[i]);
        }
        //1라운드 부터 시작
        int round = 1;
        int target = n + 1;

        while(idx < n){

            if(hand.isEmpty()) break;

            boolean found = false;
            //두장의 카드 뽑기
            if(idx < n) draw.add(cards[idx++]);
            if(idx < n) draw.add(cards[idx++]);

            int removeA = 0;
            int removeB = 0;
            //내 손패에서 해결 가능할때
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

            //코인 하나로 해결 가능할때
            if(coin > 0){
                for(int a : hand){
                    int b = target - a;
                    if(draw.contains(b)){
                        removeA = a;
                        removeB = b;
                        found = true;
                        coin -= 1;
                        break;
                    }
                }
            }

            if(found){
                hand.remove(removeA);
                draw.remove(removeB);
                round++;
                continue;
            }

            //코인두개 사용 가능
            if(coin > 1){
                for(int a : draw){
                    int b = target - a;
                    if(draw.contains(b)){
                        removeA = a;
                        removeB = b;
                        found = true;
                        coin -= 2;
                        break;
                    }
                }
            }

            if(found){
                draw.remove(removeA);
                draw.remove(removeB);
                round++;
                continue;
            }

            //세가지 방법 다 못찾으면 종료ㅛ
            break;


        }

        return round;
    }

    public static void main(String[] args) throws Exception{
        int coin = 10;

        int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};

        System.out.println(solution(coin, cards));
    }

}
