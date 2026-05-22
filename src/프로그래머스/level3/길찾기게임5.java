package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 길찾기게임5 {
    static ArrayList<Node> nodes;
    static ArrayList<Integer> preorderList;
    static ArrayList<Integer> postorderList;

    static class Node implements Comparable<Node>{
        int x,y,idx;
        Node left, right;

        public Node(int x, int y, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        public int compareTo(Node other){
            if(other.y == this.y) return this.x - other.x;
            return other.y - this.y;
        }

    }

    public static int[][] solution(int[][] nodeinfo){
        nodes = new ArrayList<>();
        preorderList = new ArrayList<>();
        postorderList = new ArrayList<>();
        //노드 담기
        int idx = 1;
        for(int[] n : nodeinfo){
            int x = n[0];
            int y = n[1];

            nodes.add(new Node(x,y,idx));
            idx++;
        }
        //노드 정렬
        Collections.sort(nodes);

        Node root = nodes.get(0);
        //0이후부터 insert
        for(int i=1;i<nodes.size();i++){
            insert(root, nodes.get(i));
        }

        //전위 순회, 후위 순회
        preOrder(root);
        postOrder(root);

        //
        int[][] answer = new int[2][nodeinfo.length];

        for(int i=0;i<nodeinfo.length;i++){
            answer[0][i] = preorderList.get(i);
            answer[1][i] = postorderList.get(i);
        }

        return answer;

    }

    static void insert(Node parent, Node child){
        if(parent.x > child.x){
            if(parent.left == null){
                parent.left = child;
            }else{
                insert(parent.left, child);
            }
        }else{
            if(parent.right == null){
                parent.right = child;
            }else{
                insert(parent.right, child);
            }
        }
    }

    static void preOrder(Node root){
        if(root == null) return;
        preorderList.add(root.idx);
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        postorderList.add(root.idx);
    }

    public static void main(String[] args) throws Exception{
        int[][] nodeinfi = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        System.out.println(Arrays.deepToString(solution(nodeinfi)));
    }

}
