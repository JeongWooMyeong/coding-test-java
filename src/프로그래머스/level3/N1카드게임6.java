package 프로그래머스.level3;

import java.util.HashSet;
import java.util.Set;

public class N1카드게임6 {
    static Set<Integer> hand;
    static Set<Integer> draw;

    public static int solution(int coin, int[] cards){
        hand = new HashSet<>();
        draw = new HashSet<>();
        int n = cards.length;
        //처음카드 뽑을때 (그리고 문제에서 순서대로 카드 뽑음)
        int idx = n / 3;
        for(int i=0;i<idx;i++){
            hand.add(cards[i]);
        }
        //1라운드 부터 시작
        int round = 1;
        int target = n + 1;
        while(true){
            //내 손패에 카드 없을때 종료
            if(hand.isEmpty()) break;
            //방법 찾았을때 라운드 넘기기 위한 flag
            boolean found = false;
            //라운드 시작할때 카드 두장 뽑기
            if(idx < n) draw.add(cards[idx++]);
            if(idx < n) draw.add(cards[idx++]);

            int removeA = -1;
            int removeB = -1;

            //내 손패로 처리 가능한 경우
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

            //위의 경우 처리 못하고 코인 하나로 교체해서 하는 경우
            if(coin >= 1){
                for(int a : hand){
                    int b = target - a;
                    if(draw.contains(b)){
                        removeA = a;
                        removeB = b;
                        found = true;
                        coin -= 1;  //코인 1 제거
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

            //2개 다 교체
            if(coin >= 2){
                for(int a : draw){
                    int b = target - a;
                    //a,b가 같지 않아야함 (같으면 무조건 찾음
                    if(a != b && draw.contains(b)){
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
