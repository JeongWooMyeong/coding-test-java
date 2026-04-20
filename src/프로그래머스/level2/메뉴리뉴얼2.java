package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 메뉴리뉴얼2 {
    static Map<String, Integer> map;

    public static String[] solution(String[] orders, int[] course){
        List<String> resultList = new ArrayList<>();

        for(int len : course){
            map = new HashMap<>();
            for(String order : orders){
                char[] c = order.toCharArray();
                //AB ,BA도 같으므로 정렬해서 같게 들어가게 해야함
                Arrays.sort(c);
                dfs(c, 0, new StringBuilder(), len);
            }

            int max = 0;
            //len 단어중에서 max 값
            for(String key : map.keySet()){
                max = Math.max(max, map.get(key));
            }

            //max인 코스 메뉴 resultList에 넣기
            for(String key : map.keySet()){
                //최소 2명 이상의 손님에게서 주문된 코스요리만 후보에 들어감
                if(map.get(key) == max && max >=2){
                    resultList.add(key);
                }
            }

        }

        Collections.sort(resultList);

        return resultList.toArray(new String[0]);
    }

    static void dfs(char[] arr, int idx, StringBuilder sb, int targetLen){
        if(sb.length() == targetLen){
            String combo = sb.toString();
            map.put(combo, map.getOrDefault(combo, 0) + 1);
            return;
        }

        for(int i=idx;i<arr.length;i++){
            sb.append(arr[i]);
            dfs(arr, i+1, sb, targetLen);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    public static void main(String[] args) throws Exception{
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};

        System.out.println(Arrays.toString(solution(orders,course)));
    }
}
