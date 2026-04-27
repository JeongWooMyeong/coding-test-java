package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 다단계칫솔판매 {
    static Map<String, Node> nodes;

    static class Node{
        String name;
        Node parent;
        List<Node> children;
        int profit;

        public Node(String name){
            this.name = name;
            this.children = new ArrayList<>();
            this.profit = 0;
        }

    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount){
        nodes = new HashMap<>();
        //루트 노드
        Node root = new Node("root");
        //모든 판매원 노드 생성
        for(String name : enroll){
            nodes.put(name, new Node(name));
        }
        //트리 구성
        for(int i=0;i<enroll.length;i++){
            String childName = enroll[i];
            String parentName = referral[i];

            Node child = nodes.get(childName);
            Node parent = parentName.equals("-") ? root : nodes.get(parentName);

            child.parent = parent;
            parent.children.add(child);

        }
        //판매자에 대해서 수익 분배
        for(int i=0;i<seller.length;i++){
            Node cur = nodes.get(seller[i]);
            int money = amount[i] * 100;

            while(cur != root && money > 0){
                int give = money / 10;
                int keep = money - give;

                cur.profit += keep;
                cur = cur.parent;
                money = give;

            }
        }
        //결과 반환
        int[] answer = new int[enroll.length];

        for(int i=0;i<nodes.size();i++){
            answer[i] = nodes.get(enroll[i]).profit;
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
