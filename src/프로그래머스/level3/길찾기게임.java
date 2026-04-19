package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
이진트리
부모 값 > 자식 값 -> 자식은 왼쪽
그렇지 않으면 오른쪽
 */

public class 길찾기게임 {
    static ArrayList<Integer> preOrderList = new ArrayList<>();
    static ArrayList<Integer> postOrderList = new ArrayList<>();

    static class Node implements Comparable<Node>{
        int x, y, idx;
        Node left, right;

        public Node(int x, int y, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        public int compareTo(Node other){
            if(this.y == other.y) return this.x - other.x;
            return other.y - this.y;
        }

    }

    public static int[][] solution(int[][] nodeinfo){
        List<Node> list = new ArrayList<>();
        //노드정보 list에 담기
        int idx = 1;
        for(int[] n : nodeinfo){
            int x = n[0];
            int y = n[1];
            int i = idx;
            list.add(new Node(x,y,i));
            idx++;
        }

        //y좌표 기준으로 내림차순 정렬 (y가 큰게 root 노드)
        Collections.sort(list);
        //정렬 후 루트 노드는 첫번째
        Node root = list.get(0);
        //노드에 대해서 이진트리 insert
        for(int i=1;i<list.size();i++){
            insert(root, list.get(i));
        }

        //순회
        preorder(root);
        postorder(root);

        //결과 반환
        int[][] answer = new int[2][nodeinfo.length];
        for(int i=0;i<nodeinfo.length;i++){
            answer[0][i] = preOrderList.get(i);
            answer[1][i] = postOrderList.get(i);
        }

        return answer;

    }

    static void insert(Node root, Node child){
        if(child.x < root.x){
            if(root.left == null) root.left = child;
            else insert(root.left, child);
        }else{
            if(root.right == null) root.right = child;
            else insert(root.right, child);
        }
    }
    //전위 순회
    static void preorder(Node node){
        if(node == null) return;
        preOrderList.add(node.idx);
        preorder(node.left);
        preorder(node.right);
    }

    //후위 순회
    static void postorder(Node node){
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        postOrderList.add(node.idx);
    }

    public static void main(String[] args) throws Exception{
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        System.out.println(Arrays.deepToString(solution(nodeinfo)));
    }

}
