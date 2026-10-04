package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 전화번호목록14 {

    static int T;
    static int n;
    static String[] numarr;
    static StringBuilder sb;
    static class Node{
        Node[] child = new Node[10];
        boolean isEnd;
    }
    static Node root;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        while(T-- > 0){
            n = Integer.parseInt(br.readLine());
            numarr = new String[n];
            root = new Node();

            for(int i=0;i<n;i++){
                numarr[i] = br.readLine();
                insert(numarr[i]);
            }

            boolean found = true;
            for(int i=0;i<n;i++){
                if(!isConsistent(numarr[i])){
                    found = false;
                    break;
                }
            }

            if(found) sb.append("YES");
            else sb.append("NO");

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
