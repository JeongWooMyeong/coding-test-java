package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 트리순회2 {

    static int N;
    static Map<Character, Node> map;
    static List<Character> preorderList;
    static List<Character> postorderList;
    static List<Character> midorderList;
    static class Node{
        Character node;
        Node left, right;

        public Node(Character node){
            this.node = node;
        }

    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        preorderList = new ArrayList<>();
        postorderList = new ArrayList<>();
        midorderList = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            map.putIfAbsent(parent, new Node(parent));
            Node root = map.get(parent);

            if(left != '.'){
                map.putIfAbsent(left, new Node(left));
                root.left = map.get(left);
            }

            if(right != '.'){
                map.putIfAbsent(right, new Node(right));
                root.right = map.get(right);
            }

        }

        Node root = map.get('A');
        preOrder(root);
        postOrder(root);
        midOrder(root);

        StringBuilder sb = new StringBuilder();

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

    static void preOrder(Node root){
        if(root == null) return;
        preorderList.add(root.node);
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        postorderList.add(root.node);
    }

    static void midOrder(Node root){
        if(root == null) return;
        midOrder(root.left);
        midorderList.add(root.node);
        midOrder(root.right);
    }

}
