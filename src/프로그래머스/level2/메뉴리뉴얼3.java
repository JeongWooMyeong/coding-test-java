package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 메뉴리뉴얼3 {
    static Map<String, Integer> map;


    public static String[] solution(String[] orders, int[] course){
        map = new HashMap<>();
        //각 주문에 대해서 각 경우의 수 구하기
        for(String order : orders){
            char[] c = order.toCharArray();
            Arrays.sort(c);
            for(int len : course){
                dfs(0, 0,new StringBuilder(), c, len);
            }
        }

        List<String> resultList = new ArrayList<>();
        for(int len : course){
            int maxcount = 0;
            //일단 길이마다 최고 많이 먹은 횟수 구해야함
            for(String key : map.keySet()){
                if(key.length() == len) {
                    maxcount = Math.max(maxcount, map.get(key));
                }
            }

            for(String key : map.keySet()){
                if(key.length() == len && map.get(key) == maxcount && maxcount >= 2){
                    resultList.add(key);
                }
            }
        }

        Collections.sort(resultList);

        String[] answer = new String[resultList.size()];
        for(int i=0;i<resultList.size();i++){
            answer[i] = resultList.get(i);
        }

        return answer;
    }

    static void dfs(int idx, int depth, StringBuilder sb, char[] c, int target){
        if(depth == target){
            String combo = sb.toString();

            if(!map.containsKey(combo)){
                map.put(combo, 1);
            }else{
                map.put(combo, map.get(combo) + 1);
            }

            return;
        }
        if(idx >= c.length) return;


        sb.append(c[idx]);
        //현재 문자 선택
        dfs(idx + 1, depth +1, sb, c, target);
        sb.deleteCharAt(sb.length() - 1);
        //선태하지 않음
        dfs(idx + 1, depth, sb, c, target);

    }

    public static void main(String[] args) throws Exception{
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};

        System.out.println(Arrays.toString(solution(orders, course)));
    }



}
