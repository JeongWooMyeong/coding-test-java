package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 암호만들기 {
    static int L;
    static int C;
    static char[] letters;
    static StringBuilder sb = new StringBuilder();
    static char[] result;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        letters = new char[C];
        for(int i=0;i<C;i++){
            letters[i] = sc.next().charAt(0);
        }
        Arrays.sort(letters);
        result = new char[L];
        dfs(0, 0);
        System.out.print(sb);


    }

    static void dfs(int depth, int start){
        if(depth == L){
            if(isValid(result)){
                sb.append(new String(result)).append("\n");
            }
            return;
        }
        for(int i=start;i<C;i++){
            result[depth] = letters[i];
            dfs(depth +1, i+1);
        }
    }

    static boolean isValid(char[] arr){
        int vowels = 0, consonants = 0;
        for(char ch : arr){
            if("aeiou".indexOf(ch) >= 0) vowels++;
            else consonants++;
        }
        return vowels >= 1 && consonants >= 2;
    }

}
