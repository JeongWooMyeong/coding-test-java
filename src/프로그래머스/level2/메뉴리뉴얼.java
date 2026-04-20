package 프로그래머스.level2;

import java.util.*;
import java.io.*;


/*
내가 만든 초안 -> 빈약함..
 */

public class 메뉴리뉴얼 {
    static Map<String, Integer> map;
    static List<String> resultList = new ArrayList<>();

    public static String[] solution(String[] orders, int[] course){
        //코스 길이
        for(int len : course){
            //길이마다 인기 많은 조합을 뽑아야 하므로 map을 길이마다 초기화
            map = new HashMap<>();
            for(String order : orders){
                char[] c = order.toCharArray();
                //믄자열 ㅈ어리
                Arrays.sort(c);
                dfs(c, 0, new StringBuilder(), len);
            }

            int max = 0;
            for(String key : map.keySet()){
                max = Math.max(max, map.get(key));
            }

            for(String key : map.keySet()){
                if(map.get(key) == max && max >= 2){
                    resultList.add(key);
                }
            }

        }

        Collections.sort(resultList);
        //이거 봤었는데 기억 안남
        return resultList.toArray(new String[0]);
    }

    static void dfs(char[] arr, int idx, StringBuilder sb, int targetLen){
        if(sb.length() == targetLen){
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
            return;
        }

        for(int i=idx;i<arr.length;i++){
            sb.append(arr[i]);
            dfs(arr, i+1, sb, targetLen);
            //이거 뭐지
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) throws Exception{
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};

        System.out.println(Arrays.toString(solution(orders,course)));
    }

}
