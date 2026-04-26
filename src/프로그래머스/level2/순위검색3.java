package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 순위검색3 {
    static Map<String, List<Integer>> map;

    public static int[] solution(String[] info, String[] query){
        map = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();

        for(String ex : info){
            String[] arr = ex.split(" ");
            dfs(0, "", arr, map, Integer.parseInt(arr[4]));
        }

        //score 기준으로 정렬
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }

        for(String q : query){
            String[] str = q.replaceAll(" and ", " ").split(" ");

            String key = "";
            int value = Integer.parseInt(str[str.length-1]);
            for(int i =0;i<str.length-1;i++){
                key += str[i];
            }

            List<Integer> scoreList = map.get(key);
            //사이즈 말고 null 체크로 해줘야 오류 발생 안함
            if(scoreList != null){
                int idx = lowerBound(value, scoreList);
                resultList.add(scoreList.size() - idx);
            }else{
                resultList.add(0);
            }

        }

        int[] answer = new int[resultList.size()];
        for(int i=0;i<resultList.size();i++){
            answer[i] = resultList.get(i);
        }

        return answer;

    }

    static void dfs(int idx, String path, String[] arr, Map<String, List<Integer>> map, int score){
        if(idx == 4){
            if(!map.containsKey(path)){
                map.put(path, new ArrayList<>());
                map.get(path).add(score);
            }else{
                map.get(path).add(score);
            }
            return;
        }

        //현재 string 포함
        dfs(idx + 1, path + arr[idx], arr, map, score);
        //현재 string 안넣고 모든경우의 수 - 넣기
        dfs(idx + 1, path + "-", arr, map, score);


    }

    static int lowerBound(int target, List<Integer> list){
        int left = 0; int right = list.size();
        while(left < right){
            int mid = (left + right) / 2;

            if(list.get(mid) < target){
                left = mid + 1;
            }else{
                right = mid;
            }

        }
        return left;
    }

    public static void main(String[] args) throws Exception{
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        int[] answer = solution(info, query);

        for(int x : answer){
            System.out.println(x);
        }
    }

}
