package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class N1카드게임3 {
    public static int solution(int coin, int[] cards){
        //HashSet , list로 하면 카드 제거 넣고 하니 index로 해서 복잡
        //그리고 문제에서 중복 안됌 카드
        Set<Integer> hand = new HashSet<>();
        Set<Integer> draw = new HashSet<>();

        int N = cards.length;   //카드 개수
        int idx = N / 3;    //처음 받는 카드의 개수
        int target = N+1;   //두 개의 카드 합해서 내야할 수
        //주어진 cards가 순서대로 카드를 뽑도록 되어 있음
        for(int i=0;i<idx;i++){
            hand.add(cards[i]);
        }

        //반복문 시행
        int round = 1; //1라운드 부터 시작
        while(true){
            //내 손에 카드 없으면 즉시 종료
            if(hand.isEmpty()) break;

            //라운드마다 2장의 카드 뽑음 (idx부터)
            if(idx < N) draw.add(cards[idx++]);
            if(idx < N) draw.add(cards[idx++]);

            //각 조건에 만족했을때 boolean flag
            boolean found = false;

            //내 손패에서 해결 가능한지 확인
            for(int a : hand){
                int b = target - a;
                //만약 b가 내 손패에 포함되어 있는지 확인
                if(hand.contains(b)){
                    hand.remove(a);
                    hand.remove(b);
                    found = true;
                    //찾았으니 바로 break
                    break;
                }
            }
            //손패에서 찾앗으면 다음 라운드 이동
            if(found){
                round++;
                continue;
            }

            //손패에서 해결못하면 내 수중에 있는 코인 하나로 해결 (최대 2개) -> 카드 두장 내므로
            if(coin >= 1){
                for(int a : hand){
                    int b = target - a;
                    //뽑은 카드 중에 b가 포함되어 있으면
                    if(draw.contains(b)){
                        hand.remove(a);
                        draw.remove(b);
                        found = true;
                        //여기서는 코인 하나 사용
                        coin--;
                        break;
                    }
                }
                if(found){
                    round++;
                    continue;
                }
            }
            //하나로도 못찾으면 코인 두개 사용 (두개가 최대)
            if(coin >= 2){
                //이건 draw에서 찾으면서 해야함
                //근데 draw hashset이고 hashset은 list 구조가 아니므로 불러 올 수 없음
                List<Integer> list = new ArrayList<>(draw);
                for(int i=0;i<list.size();i++){
                    for(int j=i+1;j<list.size();j++){
                        int a = list.get(i);
                        int b = list.get(j);
                        if(a+b == target){
                            found = true;
                            draw.remove(a);
                            draw.remove(b);
                            //코인 사용했으니 코인 감소해야함
                            coin -= 2;
                            break;
                        }
                    }
                    if(found) break;
                }

                if(found){
                    round++;
                    continue;
                }
            }

            break;
        }
        //종료 되면 최종 round 리턴
        return round;
    }

    public static void main(String[] args) throws Exception{
        int coin = 3;
        int[] cards = {1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12};

        System.out.println(solution(coin, cards));
    }
}
