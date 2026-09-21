package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 트리순회4 {

    static int N;
    static Map<Character, Node> map;
    static List<Character> preorderList;
    static List<Character> postorderList;
    static List<Character> inorderList;
    static class Node{
        char node;
        Node left;
        Node right;

        public Node(char node){
            this.node = node;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new HashMap<>();

        N = Integer.parseInt(br.readLine());

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

        //Node root = new Node('A');
        Node root = map.get('A');

        preorder(root);
        inorder(root);
        postorder(root);

        StringBuilder sb = new StringBuilder();

        for(char x : preorderList){
            sb.append(x);
        }

        sb.append("\n");

        for(char x : inorderList){
            sb.append(x);
        }

        sb.append("\n");

        for(char x : postorderList){
            sb.append(x);
        }

        System.out.println(sb);

    }

    static void preorder(Node root){
        if(root == null) return;
        preorderList.add(root.node);
        preorder(root.left);
        preorder(root.right);
    }

    static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        inorderList.add(root.node);
        inorder(root.right);
    }

    static void postorder(Node root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        postorderList.add(root.node);
    }

}
