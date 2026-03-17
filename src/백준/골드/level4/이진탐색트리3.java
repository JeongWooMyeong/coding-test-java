package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 이진탐색트리3 {
    static class Node{
        int value;
        Node left, right;

        Node(int value ){
            this.value = value;
        }

        void insert(int val){
            if(this.value > val){
                if(left == null) this.left = new Node(val);
                else this.left.insert(val);
            }else{
                if(right == null) this.right = new Node(val);
                else this.right.insert(val);
            }
        }

    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Node root = new Node(Integer.parseInt(line));

        while((line = br.readLine()) != null){
            if(line.trim().isEmpty()) break;
            root.insert(Integer.parseInt(line));
        }

        postorder(root);
        System.out.print(sb);

    }

    static void postorder(Node node){
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        sb.append(node.value).append("\n");
    }
}
