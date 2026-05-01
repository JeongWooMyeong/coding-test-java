package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 다단계칫솔판매4 {
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
        Node root = new Node("root");

        //노드 등록
        for(String name : enroll){
            nodes.put(name, new Node(name));
        }

        //관련 노드 등록 (부모, 자식)
        for(int i=0;i<enroll.length;i++){
            String childName = enroll[i];
            String parentName = referral[i];

            Node child = nodes.get(childName);
            Node parent = parentName.equals("-") ? root : nodes.get(parentName);

            child.parent = parent;
            parent.children.add(child);

        }

        //seller 돌면서 이익금 누적
        for(int i=0;i<seller.length;i++){
            int money = 100 * amount[i];
            Node current = nodes.get(seller[i]);

            while(current != root && money > 0){
                int need = money / 10;
                int keep = money - need;
                current.profit += keep;
                current = current.parent;
                money = need;

            }

        }

        int[] answer = new int[enroll.length];
        for(int i=0;i<enroll.length;i++){
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
