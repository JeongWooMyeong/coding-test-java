package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 순위검색4 {

    static Map<String, List<Integer>> map;

    public static int[] solution(String[] info, String[] query){
        map = new HashMap<>();

        for(String str : info){
            String[] arr = str.split(" ");
            int score = Integer.parseInt(arr[4]);

            dfs(0,"",arr,score);

        }
        //점수 오름차순 정렬
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }

        int[] answer = new int[query.length];
        int num = 0;

        for(String q : query){
            String[] arr = q.replaceAll(" and ", " ").split(" ");
            String key = "";
            for(int i=0;i<arr.length-1;i++){
                key += arr[i];
            }
            int target = Integer.parseInt(arr[arr.length-1]);
            List<Integer> scoreList = map.get(key);

            if(scoreList != null) {
                int idx = lowerBound(scoreList, target);
                answer[num] = scoreList.size() - idx;
            }else{
                answer[num] = 0;
            }

            num++;

        }

        return answer;

    }

    static void dfs(int idx, String key, String[] arr, int score){
        if(idx == 4){
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(score);

            return;

        }

        //
        dfs(idx+1, key + arr[idx], arr, score);

        dfs(idx+1, key + "-", arr, score);

    }

    static int lowerBound(List<Integer> list, int target){
        int left = 0; int right = list.size();
        while(left < right){
            int mid = (left + right) / 2;

            if(list.get(mid) < target){
                left = mid+1;
            }else{
                right = mid;
            }

        }

        return left;
    }

    public static void main(String[] args) throws Exception{
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        System.out.println(Arrays.toString(solution(info, query)));
    }

}
