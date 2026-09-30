package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 순위검색9 {

    static int[] answer;
    static Map<String, List<Integer>> map;

    public static int[] solution(String[] info, String[] query){

        map = new HashMap<>();

        for(String str : info){
            String[] arr = str.split(" ");

            dfs(0, "", arr);

        }

        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }

        answer = new int[query.length];

        int idx = 0;
        for(String str : query){
            String[] arr = str.replace(" and ", " ").split(" ");
            String q = "";
            for(int i=0;i<4;i++){
                q += arr[i];
            }
            int score = Integer.parseInt(arr[4]);


            if(!map.containsKey(q)){
                answer[idx++] = 0;
            }else{
                List<Integer> scoreList = map.get(q);
                answer[idx++] = scoreList.size() - lowerbound(score, scoreList);
            }

        }

        return answer;

    }

    static void dfs(int idx, String path, String[] arr){
        if(idx == 4){
            map.putIfAbsent(path, new ArrayList<>());
            map.get(path).add(Integer.parseInt(arr[idx]));
            return;
        }

        dfs(idx+1, path + arr[idx], arr);

        dfs(idx+1, path+"-", arr);

    }

    static int lowerbound(int target, List<Integer> list){
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
