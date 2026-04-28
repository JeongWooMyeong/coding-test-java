package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 큰수만들기2 {
    static Set<Integer> resultList;
    static int maxValue = Integer.MIN_VALUE;

    public static String solution(String number, int k){
        String answer = "";
        char[] c = number.toCharArray();
        resultList = new HashSet<>();

        dfs(0, 0, "", k, c);

        return String.valueOf(maxValue);
    }

    static void dfs(int idx, int depth, String path, int target, char[] arr){
        if(depth == arr.length - target){
            maxValue = Math.max(maxValue, Integer.parseInt(path));
            return;
        }

        if(idx == arr.length) return;

        dfs(idx +1 , depth +1, path + arr[idx], target, arr);

        dfs(idx+1, depth, path, target, arr);

    }

    public static void main(String[] args) throws Exception{
        String number = "1231234";
        int k = 3;
        System.out.println(solution(number, k));
    }

}
