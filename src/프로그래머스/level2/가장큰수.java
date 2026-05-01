package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 가장큰수 {
    static boolean[] visited;
    static List<String> result;
    static int maxLength;

    public static String solution(int[] numbers){
        String[] arr = new String[numbers.length];
        result= new ArrayList<>();
        maxLength = 0;
        for(int i=0;i<numbers.length;i++){
            arr[i] = String.valueOf(numbers[i]);
            maxLength += arr[i].length();
        }

        visited = new boolean[numbers.length];
        dfs(0,arr, new StringBuilder());

        Collections.sort(result, Collections.reverseOrder());

        return result.get(0);

    }

    static void dfs(int idx, String[] arr, StringBuilder sb){
        if(sb.length() == maxLength){
            result.add(sb.toString());
        }

        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                sb.append(arr[i]);
                visited[i] = true;
                dfs(idx+1, arr, sb);
                //sb.deleteCharAt(sb.length()-1);
                sb.delete(sb.length() - arr[i].length(), sb.length());
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws Exception{
        int[] numbers = {6,10,2};
        System.out.println(solution(numbers));
    }


}
