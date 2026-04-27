package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 다단계칫솔판매2 {
    static Map<String, Node> nodes;

    static class Node{
        String name;
        Node parent;
        List<Node> children;
        int profit;

        public Node(String name){
            this.name = name;
            children = new ArrayList<>();
            profit = 0;
        }

    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount){
        nodes = new HashMap<>();
        Node root = new Node("root");

        //등록된 사람들 노드 생성
        for(String name : enroll){
            nodes.put(name, new Node(name));
        }

        //노드 연결
        for(int i=0;i<enroll.length;i++){
            String parentName = referral[i];
            String childName= enroll[i];

            Node child = nodes.get(childName);
            Node parent = parentName.equals("-") ? root : nodes.get(parentName);

            child.parent = parent;
            parent.children.add(child);

        }

        //수익분배
        for(int i=0;i<seller.length;i++){
            Node n = nodes.get(seller[i]);
            int money = amount[i] * 100;

            while(n != root && money > 0){
                int give = money / 10;
                int keep = money - give;
                //현재 노드에서 갖는 이윤 구하기
                n.profit += keep;
                //다음은 n의 부모노드
                n = n.parent;
                //다음 노드가 갖는 money는 give로
                money = give;
            }

        }

        //결과값 도출
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
