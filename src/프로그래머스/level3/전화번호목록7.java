package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 전화번호목록7 {

    static int t, n;
    static class Node{
        Node[] child = new Node[10];
        boolean isEnd;
    }
    static Node root;
    static StringBuilder sb;
    static String[] numbers;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            numbers = new String[n];

            root = new Node();

            for(int i=0;i<n;i++){
                numbers[i] = br.readLine();
                insert(numbers[i]);
            }

            boolean found = true;

            for(int i=0;i<n;i++){
                if(!isConsistent(numbers[i])){
                    found = false;
                    break;
                }
            }

            if(found) sb.append("YES\n");
            else sb.append("NO\n");

        }

        System.out.println(sb);

    }

    static void insert(String number){
        Node cur = root;

        for(int i=0;i<number.length();i++){
            int idx = number.charAt(i) - '0';

            if(cur.child[idx] == null){
                cur.child[idx] = new Node();
            }

            cur = cur.child[idx];
        }

        cur.isEnd = true;
    }

    static boolean isConsistent(String number){
        Node cur = root;

        for(int i=0;i<number.length();i++){
            int idx = number.charAt(i) - '0';

            cur = cur.child[idx];

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
