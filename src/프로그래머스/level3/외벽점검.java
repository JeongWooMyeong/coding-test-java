package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 외벽점검 {
    static int[] map;
    static List<List<Integer>> set;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static int solution(int n, int[] weak, int[] dist){
        map = new int[weak.length * 2];
        set = new ArrayList<>();
        visited = new boolean[n];
        for(int i=0;i<map.length;i++){
            if(i < weak.length){
                map[i] = weak[i];
            }else{
                map[i] = map[i%weak.length] + n;
            }
        }

        //친구 경우의 수 구하기
        dfs(0, dist, new ArrayList<>());

//        for(List<Integer> s : set){
//            System.out.println(s.toString());
//        }
        //취약지점 하나씩 경우의 수 하면서 최소 친구의 수 구하기
        for(int i=0;i<weak.length;i++){
            for(List<Integer> friends : set){
                int cnt = 1;
                int pos = map[i] + friends.get(0);

                int j;
                for(j=i;j<i+weak.length;j++){
                    if(map[j] > pos){
                        cnt++;
                        if(cnt > friends.size()) break;
                        pos = map[j] + friends.get(cnt-1);
                    }
                }

                if(j == i+weak.length) {
                    answer = Math.min(answer, cnt);
                }

            }

        }

        if(answer == Integer.MAX_VALUE) return -1;

        return answer;
    }

    static void dfs(int idx, int[] dist, List<Integer> selected){
        if(idx == dist.length){
            set.add(new ArrayList<>(selected));
            return;
        }

        for(int i=0;i<dist.length;i++){
            if(!visited[i]){
                visited[i] = true;
                selected.add(dist[i]);
                dfs(idx+1, dist, selected);
                visited[i] = false;
                selected.remove(selected.size()-1);
            }
        }



    }

    public static void main(String[] args) throws Exception{
        int n = 12;
        int[] weak = {1,5,6,10};
        int[] dist = {1,2,3,4};

        System.out.println(solution(n, weak, dist));
    }

}
