package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 자동완성2 {

    static class Node{
        Node[] child = new Node[26];
        int count = 0;
    }
    static int answer;
    static Node root;

    public static int solution(String[] words){

        answer = 0;

        root = new Node();

        for(String word : words){
            insert(word);
        }

        for(String word : words){
            Node cur = root;
            for(int i=0;i<word.length();i++){
                int idx = word.charAt(i) - 'a';

                cur = cur.child[idx];

                if(cur.count == 1){
                    answer += i+1;
                    break;
                }

                if(i == word.length() - 1){
                    answer += word.length();
                }

            }
        }

        return answer;

    }

    static void insert(String str){
        Node cur = root;

        for(int i=0;i<str.length();i++){
            int idx = str.charAt(i) - 'a';

            if(cur.child[idx] == null){
                cur.child[idx] = new Node();
            }

            cur = cur.child[idx];
            cur.count++;

        }

    }

    public static void main(String[] args) throws Exception{
        String[] words = {"go","gone","guild"};
        System.out.println(solution(words));
    }

}
