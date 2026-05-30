package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 메뉴리뉴얼7 {

    static Map<String, Integer> comboMap;
    static ArrayList<String> resultList;

    public static String[] solution(String[] orders, int[] course){

        comboMap = new HashMap<>();
        resultList = new ArrayList<>();

        for(int len : course){

            for(String order : orders) {
                char[] c = order.toCharArray();
                //ㅇ거 그러면 정렬해야함
                Arrays.sort(c);
                dfs(0, len, "", c);
            }

            int maxCount = 0;
            for(String key : comboMap.keySet()){
                if(key.length() == len){
                    maxCount = Math.max(maxCount, comboMap.get(key));
                }
            }

            for(String key : comboMap.keySet()){
                if(key.length() == len && maxCount >= 2 && comboMap.get(key) == maxCount){
                    resultList.add(key);
                }
            }

        }

        Collections.sort(resultList);


        return resultList.toArray(new String[0]);
    }

    static void dfs(int idx, int targetSize, String combo, char[] arr){
        if(combo.length() == targetSize){
            comboMap.put(combo, comboMap.getOrDefault(combo, 0) + 1);
            return;
        }

        for(int i=idx;i<arr.length;i++){
            dfs(i+1, targetSize, combo + arr[i], arr);
        }

    }

    public static void main(String[] args) throws Exception{
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};

        System.out.println(Arrays.toString(solution(orders, course)));
    }

}
