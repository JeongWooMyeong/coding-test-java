package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
노드 구조체로 하는 방법도 있ㄴ느데
그냥 부모노드, profit 만 해서 구하는 방법도 있음
더 간단함..
 */

public class 다단계칫솔판매3 {
    static Map<String, String> parent;
    static Map<String, Integer> profit;

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount){
        parent = new HashMap<>();
        profit = new HashMap<>();
        //부모노드 및 profit map 저장
        for(int i=0;i<enroll.length;i++){
            parent.put(enroll[i], referral[i].equals("-") ? "root" : referral[i]);
            profit.put(enroll[i], 0);
        }
        //수익 분배
        for(int i=0;i<seller.length;i++){
            String cur = seller[i];
            int money = amount[i] * 100;
            
            while(!cur.equals("root") && money > 0){
                String parents = parent.get(cur);
                int give = money / 10;
                int keep = money - give;
                
                profit.put(cur, profit.get(cur) + keep);
                money = give;
                cur = parents;
                
            }
            
        }

        //결과 도출
        int[] answer = new int[enroll.length];
        for(int i=0;i<enroll.length;i++){
            answer[i] = profit.get(enroll[i]);
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12,4,2,5,10};

        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
    }

}
