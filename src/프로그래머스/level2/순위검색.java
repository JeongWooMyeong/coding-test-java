package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 순위검색 {
    static Map<String, List<Integer>> map = new HashMap<>();

    public static int[] solution(String[] info, String[] query){
        int[] answer = new int[query.length];
        //1. info 전처리 (dfs로 조합 생성)
        for(String apply : info){
            String[] p = apply.split(" ");
            dfs(p, 0, "", Integer.parseInt(p[4]));
        }

        //2. 점수 정렬
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }

        //3. query 처리
        for(int i=0;i<query.length;i++){
            String q = query[i].replaceAll(" and ", " ");
            String[] arr = q.split(" ");

            String key = arr[0] + arr[1] + arr[2] + arr[3];
            int score = Integer.parseInt(arr[4]);

            if(!map.containsKey(key)){
                answer[i] = 0;
                continue;
            }

            List<Integer> list = map.get(key);
            int idx = lowerBound(list, score);
            answer[i] = list.size() - idx;
        }


        return answer;

    }

    static void dfs(String[] arr, int idx, String key, int score){
        if(idx == 4){
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(score);
            return;
        }

        //현재 값 선택
        dfs(arr, idx+1, key + arr[idx], score);

        //- 선택
        dfs(arr, idx+1, key + "-", score);

    }

    static int lowerBound(List<Integer> list, int target){
        int left = 0;
        int right = list.size();

        while(left < right){
            int mid = (left + right) / 2;

            if(list.get(mid) >= target){
                right = mid;
            }else{
                left = mid + 1;
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
