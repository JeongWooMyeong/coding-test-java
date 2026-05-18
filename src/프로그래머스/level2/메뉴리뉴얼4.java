package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 메뉴리뉴얼4 {
    static Map<String, Integer> map;
    static boolean[] visited;
    static String[] answer;
    static ArrayList<String> resultList;

    public static String[] solution(String[] orders, int[] course){
        //answer = new String[course.length];
        resultList = new ArrayList<>();
        map = new HashMap<>();
        int idx = 0;
        for(int len : course){

            for(String order : orders){
                visited = new boolean[order.length()];
                char[] c = order.toCharArray();
                Arrays.sort(c);
                dfs(0,len,"",c);
            }

            int maxCount = Integer.MIN_VALUE;
            for(String key : map.keySet()){
                if(key.length() == len) {
                    maxCount = Math.max(map.get(key), maxCount);
                }
            }

            for(String key : map.keySet()){
                if(key.length() == len) {
                    if (map.get(key) == maxCount && maxCount >= 2) resultList.add(key);
                }
            }
        }

        Collections.sort(resultList);


        return resultList.toArray(new String[0]);

    }

    static void dfs(int idx,int depth, String combo, char[] arr){

        if(combo.length() == depth){
           if(!map.containsKey(combo)){
               map.put(combo, 1);
           }else{
               map.put(combo, map.get(combo)+1);
           }
           return;
        }

        if(idx >= arr.length) return;

        for(int i=idx;i<arr.length;i++){
            //if(!visited[i]){
                //visited[i] = true;
                dfs(i+1, depth,combo+arr[i], arr);
                //visited[i] = false;
            //}
        }

    }

    public static void main(String[] args) throws Exception{
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};

        System.out.println(Arrays.toString(solution(orders, course)));
    }


}
