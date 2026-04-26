package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class N1카드게임4 {
    static Set<Integer> hands;
    static Set<Integer> draw;

    public static int solution(int coin, int[] cards) {
        int n = cards.length;
        int idx = n / 3;
        int target = n + 1;
        hands = new HashSet<>();
        draw = new HashSet<>();
        //받은 카드 저장
        for (int i = 0; i < idx; i++) {
            hands.add(cards[i]);
        }

        int round = 1;
        while (true) {

            if (hands.isEmpty()) break;

            //2장 뽑기
            if (idx < n) draw.add(cards[idx++]);
            if (idx < n) draw.add(cards[idx++]);

            boolean found = false;
            int removeA = -1, removeB = -1;
            //내 손패에서 해결 가능한 경우
            if (!hands.isEmpty()) {
                for (int a : hands) {
                    int b = target - a;
                    if (a != b && hands.contains(b)) {
                        found = true;
                        removeA = a;
                        removeB = b;
                        break;
                    }
                }
            }
            if (found) {
                hands.remove(removeA);
                hands.remove(removeB);
                round++;
                continue;
            }

            //코인하나로 해결
            if (coin >= 1 && !hands.isEmpty()) {
                for (int a : hands) {
                    int b = target - a;
                    if (draw.contains(b)) {
                        removeA = a;
                        removeB = b;
                        found = true;
                        coin--;
                        break;
                    }
                }
            }

            if (found) {
                hands.remove(removeA);
                draw.remove(removeB);
                round++;
                continue;
            }

            //코인 두개 (두장 교체)
            if (coin >= 2 && !draw.isEmpty()) {
                for (int a : draw) {
                    int b = target - a;
                    if (draw.contains(b) && a != b) {
                        removeA = a;
                        removeB = b;
                        coin -= 2;
                        found = true;
                        break;
                    }
                }
            }

            if (found) {
                draw.remove(removeA);
                draw.remove(removeB);
                round++;
                continue;
            }

            break;

        }
        return round;
    }

    public static void main(String[] args) throws Exception {
        int coin = 3;
        int[] cards = {1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12};

        System.out.println(solution(coin, cards));
    }

}
