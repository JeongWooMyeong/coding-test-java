package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 길찾기게임2 {
    static ArrayList<Integer> preorderList;
    static ArrayList<Integer> postorderList;
    static ArrayList<Node> edges;

    static class Node implements Comparable<Node>{
        int x,y,idx;
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
        edges = new ArrayList<>();
        preorderList = new ArrayList<>();
        postorderList = new ArrayList<>();
        int n = nodeinfo.length;

        for(int i=0;i<n;i++){
            int[] node = nodeinfo[i];
            int x = node[0];
            int y = node[1];
            int idx = i+1;

            edges.add(new Node(x,y,idx));

        }

        //y축 기준으로 정렬
        Collections.sort(edges);

        Node root = edges.get(0);

        for(int i=1;i<edges.size();i++){
            insertNode(root, edges.get(i));
        }

        preorder(root);
        postorder(root);

        int[][] answer = new int[2][edges.size()];
        for(int i=0;i<edges.size();i++){
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

    static void preorder(Node node){
        if(node == null) return;
        preorderList.add(node.idx);
        preorder(node.left);
        preorder(node.right);
    }

    static void postorder(Node node){
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        postorderList.add(node.idx);
    }

    public static void main(String[] args) throws Exception{
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        System.out.println(Arrays.deepToString(solution(nodeinfo)));
    }

}
