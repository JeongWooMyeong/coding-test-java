package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 다단계칫솔판매7 {
    static Map<String, String> parent;
    static Map<String, Integer> profit;

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount){
        parent = new HashMap<>();
        profit = new HashMap<>();

        for(int i=0;i<enroll.length;i++){
            String current = enroll[i];

            String parentName = referral[i].equals("-") ? "root" : referral[i];

            parent.put(current, parentName);
            profit.put(current, 0);

        }

        for(int i=0;i<seller.length;i++){
            int money = amount[i] * 100;
            String current = seller[i];

            while(!"root".equals(current) && money > 0){
                int need = money / 10;
                int keep = money - need;
                profit.put(current, profit.getOrDefault(current, 0) + keep);
                money = need;
                current = parent.get(current);
            }

        }

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
