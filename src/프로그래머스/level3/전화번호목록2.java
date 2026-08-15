package 프로그래머스.level3;

import java.util.*;
import java.io.*;
/*
트라이 검색 문자열으 한 그자씩 트리에 저장하는 자료구조
 */

public class 전화번호목록2 {

    static class Node{
        Node[] child = new Node[10];
        boolean isEnd;
    }

    static Node root;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());

            root = new Node();

            String[] numbers = new String[N];

            for(int i=0;i<N;i++){
                numbers[i] = br.readLine();
                insert(numbers[i]);
            }

            boolean consistent = true;

            for(String number : numbers){
                if(!isConsistent(number)){
                    consistent = false;
                    break;
                }
            }

            sb.append(consistent ? "YES\n" : "NO\n");

        }

        System.out.println(sb);

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

    static boolean isConsistent(String number){
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
