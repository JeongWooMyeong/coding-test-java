package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 길찾기게임8 {
    static ArrayList<Node> nodes;
    static List<Integer> preorderList;
    static List<Integer> postorderList;
    static int[][] answer;
    static class Node implements Comparable<Node>{
        int x, y, idx;
        Node left, right;
        public Node(int x, int y, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        public int compareTo(Node other){
            if(this.y == other.y){
                return this.x - other.x;
            }
            return other.y - this.y;
        }
    }

    public static int[][] solution(int[][] nodeinfo){
        nodes = new ArrayList<>();
        preorderList = new ArrayList<>();
        postorderList = new ArrayList<>();

        int idx = 1;
        for(int[] node : nodeinfo){
            int x = node[0];
            int y = node[1];

            nodes.add(new Node(x,y,idx));

            idx++;

        }

        Collections.sort(nodes);

        Node root = nodes.get(0);
        for(int i=1;i<nodes.size();i++){
            insertNodes(root, nodes.get(i));
        }

        preOrder(root);
        postOrder(root);

        answer = new int[2][postorderList.size()];

        for(int i=0;i<preorderList.size();i++){
            answer[0][i] = preorderList.get(i);
            answer[1][i] = postorderList.get(i);
        }

        return answer;
    }

    static void insertNodes(Node parent, Node child){
        if(parent.x > child.x){
            if(parent.left == null){
                parent.left = child;
            }else{
                insertNodes(parent.left, child);
            }

        }else{
            if(parent.right == null){
                parent.right = child;
            }else{
                insertNodes(parent.right, child);
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
