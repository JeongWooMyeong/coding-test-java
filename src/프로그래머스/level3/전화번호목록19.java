package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 전화번호목록19 {

    static int t,n;
    static StringBuilder sb;
    static String[] numarr;
    static class Node{
        Node[] child = new Node[10];
        boolean isEnd;
    }
    static Node root;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        while(t-- > 0){
            n = Integer.parseInt(br.readLine());

            root = new Node();
            numarr = new String[n];

            for(int i=0;i<n;i++){
                String number = br.readLine();
                numarr[i] = number;
                insert(numarr[i]);
            }

            boolean found = false;

            for(int i=0;i<n;i++){
                if(!isConsistent(numarr[i])){
                    found = true;
                    break;
                }

            }

            if(found) sb.append("NO");
            else sb.append("YES");

            sb.append("\n");
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

            if(i < number.length() -1 && cur.isEnd) return false;
        }

        // 완전히 동일한 전화번호가 이미 존재하는지 검사
        if(cur.isEnd) return false;

        for(Node node : cur.child){
            if(node != null){
                return false;
            }
        }

        return true;
    }

}
