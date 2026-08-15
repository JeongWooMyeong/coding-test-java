package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 전화번호목록3 {

    static int T,n;
    static class Node{
        Node[] child = new Node[10];
        boolean isEnd;
    }

    static Node root;
    static String[] numbers;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            n = Integer.parseInt(br.readLine());
            numbers = new String[n];

            root = new Node();

            for(int i=0;i<n;i++){
                numbers[i] = br.readLine();
                insert(numbers[i]);
            }

            boolean consistent = true;

            for(int i=0;i<numbers.length;i++){
                if(!ifConsistent(numbers[i])){
                    consistent = false;
                    break;
                }
            }

            if(consistent) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");

        }

        System.out.println(sb.toString());

    }

    static void insert(String number){
        Node cur = root;

        for(char c : number.toCharArray()){
            int idx = c - '0';

            if(cur.child[idx] == null){
                cur.child[idx] = new Node();
            }

            cur = cur.child[idx];

        }

        cur.isEnd = true;

    }

    static boolean ifConsistent(String number){
        Node cur = root;

        for(int i=0;i<number.length();i++){

            cur = cur.child[number.charAt(i) - '0'];

            if(i < number.length()-1 && cur.isEnd){
                return false;
            }


        }

        for(Node child : cur.child){
            if(child != null){
                return false;
            }
        }

        return true;
    }

}
