package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 트리순회 {

    static int N;
    static List<Node> nodes;
    static List<Character> preorderList;
    static List<Character> postorderList;
    static List<Character> midorderList;
    static StringBuilder sb;

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

        N = Integer.parseInt(br.readLine());
        nodes = new ArrayList<>();
        preorderList = new ArrayList<>();
        midorderList = new ArrayList<>();
        postorderList = new ArrayList<>();
        sb = new StringBuilder();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            Node root = getNode(parent);
            root.left = getNode(left);
            root.right = getNode(right);


            nodes.add(root);
        }

        Node root = getNode('A');
        preOrder(root);
        midOrder(root);
        postOrder(root);
        for(int i=0;i<preorderList.size();i++){
            sb.append(preorderList.get(i));
        }

        sb.append("\n");

        for(int i=0;i<midorderList.size();i++){
            sb.append(midorderList.get(i));
        }

        sb.append("\n");

        for(int i=0;i<postorderList.size();i++){
            sb.append(postorderList.get(i));
        }

        System.out.println(sb.toString());
    }

    static Node getNode(char c){
        if(c == '.') return null;
        for(Node n : nodes){
            if(n.node == c) return n;
        }
        Node newNode = new Node(c);
        nodes.add(newNode);
        return newNode;
    }

    static void preOrder(Node root){
        if(root == null) return;
        preorderList.add(root.node);
        preOrder(root.left);
        preOrder(root.right);
    }

    static void midOrder(Node root){
        if(root == null) return;
        midOrder(root.left);
        midorderList.add(root.node);
        midOrder(root.right);
    }

    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        postorderList.add(root.node);
    }

}
