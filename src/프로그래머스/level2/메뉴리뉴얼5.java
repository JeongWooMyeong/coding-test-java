package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 메뉴리뉴얼5 {
    static Map<String, Integer> map;
    static ArrayList<String> resultList;

    public static String[] solution(String[] orders, int[] course){
        map = new HashMap<>();
        resultList = new ArrayList<>();

        for(int len : course){
            for(String order : orders){
                char[] c = order.toCharArray();
                Arrays.sort(c);
                dfs(0,len, "", c);
            }

            int maxCount = Integer.MIN_VALUE;
            for(String key : map.keySet()){
                if(key.length() == len){
                    maxCount = Math.max(maxCount, map.get(key));
                }
            }

            for(String key : map.keySet()){
                if(key.length() == len && map.get(key) == maxCount && maxCount >= 2){
                    resultList.add(key);
                }
            }


        }

        Collections.sort(resultList);


        return resultList.toArray(new String[0]);

    }

    static void dfs(int idx, int depth, String path, char[] c){
        if(depth == path.length()){

           map.put(path, map.getOrDefault(path, 0) + 1);
            return;

        }

        if(idx >= c.length) return;

        //현재 문자 사용
        dfs(idx+1, depth, path + c[idx], c);

        dfs(idx+1, depth,path, c);

    }

    public static void main(String[] args) throws Exception{
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};

        System.out.println(Arrays.toString(solution(orders, course)));
    }

}
