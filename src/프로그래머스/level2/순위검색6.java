package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 순위검색6 {

    static Map<String, List<Integer>> map;
    static int[] answer;
    static int n;

    public static int[] solution(String[] info, String[] query){

        n = info.length;
        map = new HashMap<>();

        for(int i=0;i<info.length;i++){
            String[] arr = info[i].split(" ");
            int score = Integer.parseInt(arr[4]);
            dfs(0, "", arr, score);
        }

        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }

        answer = new int[query.length];
        int idx = 0;
        for(String qy : query){
            String[] arr = qy.replace(" and ", " ").split(" ");
            String path = "";
            for(int i=0;i<arr.length-1;i++){
                path += arr[i];
            }
            int score = Integer.parseInt(arr[arr.length-1]);

            List<Integer> scoreList = map.get(path);

            if(scoreList == null){
                answer[idx++] = 0;
            }else{
                int lowerbound = lowerbound(scoreList,score);

                answer[idx++] = scoreList.size() - lowerbound;
            }

        }

        return answer;
    }

    static void dfs(int idx, String path, String[] arr, int score){
        if(idx == 4){
            if(!map.containsKey(path)){
                map.put(path, new ArrayList<>());
            }

            map.get(path).add(score);
            return;
        }

        dfs(idx+1,path + arr[idx], arr, score);

        dfs(idx+1, path + "-", arr, score);

    }

    static int lowerbound(List<Integer> list, int target){
        int left = 0;
        int right = list.size();

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

        System.out.println(Arrays.toString(solution(info, query)));
    }

}
