package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class N1카드게임2 {
    public static int solution(int coin, int[] cards){
        int N = cards.length;
        //뽑을 카드 의 수
        int idx = N / 3;
        int target = N+1; //이 값을 내야지만 다음 라운드로 넘어갈 수 있음

        Set<Integer> hand = new HashSet<>();
        //내 손에 뽑을 패
        for(int i=0;i<idx;i++){
            hand.add(cards[i]);
        }

        int round = 1;
        Set<Integer> draw= new HashSet<>();
        while(true){
            //손패가 업으면 더 이상 진행 불가
            if(hand.isEmpty()) break;
            //두장 뽑기
            if(idx < N) draw.add(cards[idx++]);
            if(idx < N) draw.add(cards[idx++]);

            //내 손패에 있는걸로 해결가능한지 확인 (코인 사용 X)
            boolean found = false;
            Integer sel1 = null;
            Integer sel2 = null;
            for(int a : hand){
                int b = target - a;
                if(a!=b && hand.contains(b)){
                    //hand.remove(a);
                    //hand.remove(b);
                    sel1 = a;
                    sel2 = b;
                    found = true;
                    break;
                }
            }

            //발견하면 해당하는 두장 낸것이므로 다음 라운드로 넘김
            if(found){
                hand.remove(sel1);
                hand.remove(sel2);
                round++;
                continue;
            }

            //코인 하나를 사용했을때? (손패 + 드로우 (코인 하나 사용)
            if(coin > 0) {
                Integer selA = null;
                Integer selB = null;
                for (int a : hand) {
                    int b = target - a;
                    if (a!=b && draw.contains(b)) {
                        //hand.remove(a);
                        //draw.remove(b);
                        selA = a;
                        selB = b;
                        found = true;
                        coin--;
                        break;
                    }
                }

                if(found){
                    hand.remove(selA);
                    draw.remove(selB);
                    round++;
                    continue;
                }
            }

            if(coin > 1) {
                List<Integer> list = new ArrayList<>(draw);
                Integer sel3 = null;
                Integer sel4 = null;
                for(int i=0;i<list.size();i++){
                    for(int j=i+1;j<list.size();j++){
                        int a = list.get(i);
                        int b = list.get(j);

                        if(a+b == target){
                            //draw.remove(a);
                            //draw.remove(b);
                            sel3 = a;
                            sel4 = b;
                            found = true;
                            coin -= 2;
                            break;
                        }

                    }

                    if(found){
                        break;
                    }
                }

                if(found){
                    draw.remove(sel3);
                    draw.remove(sel4);
                    round++;
                    continue;
                }

            }

            break;

        }

        return round;
    }

    public static void main(String[] args) throws Exception{
        int coin = 4;
        int[] cards = {3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4};

        System.out.println(solution(coin, cards));
    }

}
