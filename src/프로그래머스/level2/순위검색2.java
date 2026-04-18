package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 순위검색2 {
    static Map<String, List<Integer>> map = new HashMap<>();

    public static int[] solution(String[] info, String[] query){
        int[] answer = new int[query.length];

        //1. info 경우 찾기 (map에 담기) - - (전체경우) 고려
        for(int i=0;i<info.length;i++){
            String[] in = info[i].split(" ");
            dfs(0, "", in, Integer.parseInt(in[4]));
        }

        //2. 담은 map score list 점수 기준 오름차순 정렬
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }

        //3. 쿼리 기준 찾기
        for(int i=0;i<query.length;i++){
            String q = query[i].replaceAll(" and ", " ");
            String[] q2 = q.split(" ");
            int target = Integer.parseInt(q2[q2.length-1]);

            String key = q2[0] + q2[1] + q2[2] + q2[3];

            if(!map.containsKey(key)){
                answer[i] = 0;
                continue;
            }

            List<Integer> list = map.get(key);
            int idx = lowerBound(list, target);
            answer[i] = list.size() - idx;


        }
        return answer;
    }

    static void dfs(int idx, String path, String[] p, int score){
        if(idx == 4){
            if(!map.containsKey(path)){
                map.put(path, new ArrayList<>());
            }
            map.get(path).add(score);
            return;
        }

        //현재 선택
        dfs(idx + 1, path + p[idx], p, score);
        //현재 선택 안하고 - 붙이기
        dfs(idx + 1, path + "-", p, score);

    }

    static int lowerBound(List<Integer> list, int target){
        int start = 0;
        int end = list.size();

        while(start < end){
            int mid = (start + end) / 2;

            if(list.get(mid) < target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
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
