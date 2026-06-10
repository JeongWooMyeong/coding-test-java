package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 순위검색5 {

    static Map<String, List<Integer>> map;

    public static int[] solution(String[] info, String[] query){
        map = new HashMap<>();

        int[] answer = new int[query.length];

        for(String str : info){
            String[] arr = str.split(" ");
            int score = Integer.parseInt(arr[4]);
            dfs(0, "", score, arr);
        }

        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }

        int a = 0;
        for(String q : query){
            q = q.replace(" and ", " ");
            String[] arr = q.split(" ");
            String key = "";
            for(int i=0;i<4;i++){
                key += arr[i];
            }
            int target = Integer.parseInt(arr[4]);


            List<Integer> scoreList = map.get(key);
            if(scoreList == null){
                answer[a] = 0;
            }else {
                //Collections.sort(scoreList);

                int idx = lowerbound(scoreList, target);
                answer[a] = scoreList.size() - idx;
            }

            a++;
        }

        return answer;

    }

    static void dfs(int idx, String info, int score, String[] arr){
        if(idx == 4){
            if(!map.containsKey(info)){
                map.put(info, new ArrayList<>());
            }
            map.get(info).add(score);
            return;
        }

        dfs(idx+1, info + arr[idx], score, arr);

        dfs(idx+1, info + "-", score, arr);

    }

    static int lowerbound(List<Integer> scoreList, int target){
        int left = 0;
        int right = scoreList.size();

        while(left < right){
            int mid = (left + right) / 2;

            if(scoreList.get(mid) >= target){
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

        System.out.println(Arrays.toString(solution(info, query)));
    }

}
