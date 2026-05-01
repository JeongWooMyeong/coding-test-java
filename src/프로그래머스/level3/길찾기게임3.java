package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 길찾기게임3 {
    static List<Integer> preorderList;
    static List<Integer> postorderList;
    static List<Node> nodes;

    static class Node{
        int x,y,idx;
        Node left;
        Node right;

        public Node(int x, int y, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

    }

    public static int[][] solution(int[][] nodeinfo){
        preorderList = new ArrayList<>();
        postorderList = new ArrayList<>();
        nodes = new ArrayList<>();

        int idx = 1;
        //노드 정보 입력
        for(int [] node : nodeinfo){
            int x = node[0];
            int y = node[1];
            nodes.add(new Node(x,y, idx));
            idx++;
        }
        //nodes y 내림차순 정렬
        //Collections.sort(nodes, (a, b)-> a.y == b.y ? a.x - b.x : b.y - a.y);
        Collections.sort(nodes, (a, b)-> a.y == b.y ? a.x - b.x : b.y - a.y);


        //루트 노드 ㅐㅇ성
        Node root = nodes.get(0);
        //루트 노드 기준으로 트리 생성
        for(int i=1;i<nodes.size();i++){
            insertNode(root, nodes.get(i));
        }
        //전위 순회
        preorder(root);
        postorder(root);

        //정답 출력
        int[][] answer = new int[2][nodes.size()];
        for(int i=0;i<nodes.size();i++){
            answer[0][i] = preorderList.get(i);
            answer[1][i] = postorderList.get(i);
        }


       return answer;



    }

    static void insertNode(Node root, Node child){
        if(root.x > child.x){
            if(root.left == null) root.left = child;
            else insertNode(root.left, child);
        }else{
            if(root.right == null) root.right = child;
            else insertNode(root.right, child);
        }
    }

    static void preorder(Node root){
        if(root == null) return;
        preorderList.add(root.idx);
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Node root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        postorderList.add(root.idx);
    }

    public static void main(String[] args) throws Exception{
        int[][] nodeinfi = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        System.out.println(Arrays.deepToString(solution(nodeinfi)));
    }

}
