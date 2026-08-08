package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 트리순회3 {

    static int N;
    static Map<Character, Node> map;
    static ArrayList<Character> preorderList;
    static ArrayList<Character> inorderList;
    static ArrayList<Character> postorderList;
    static class Node{
        char node;
        Node left, right;

        public Node(char node){
            this.node = node;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            char current = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            map.putIfAbsent(current, new Node(current));
            Node root = map.get(current);

            if(left != '.'){
                map.putIfAbsent(left, new Node(left));
                root.left = map.get(left);
            }

            if(right != '.'){
                map.putIfAbsent(right, new Node(right));
                root.right = map.get(right);
            }
        }

        preorderList = new ArrayList<>();
        inorderList = new ArrayList<>();
        postorderList = new ArrayList<>();

        Node root = map.get('A');
        preOrder(root);
        inOrder(root);
        postOrder(root);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<preorderList.size();i++){
            sb.append(preorderList.get(i));
        }

        sb.append("\n");

        for(int i=0;i<inorderList.size();i++){
            sb.append(inorderList.get(i));
        }

        sb.append("\n");

        for(int i=0;i<postorderList.size();i++){
            sb.append(postorderList.get(i));
        }

        System.out.println(sb.toString());
    }

    static void preOrder(Node root){
        if(root == null) return;
        preorderList.add(root.node);
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        inorderList.add(root.node);
        inOrder(root.right);
    }

    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        postorderList.add(root.node);
    }

}
