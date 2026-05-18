package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 외벽점검6 {
    static int[] doubleweak;
    static boolean[] visited;
    static List<List<Integer>> friends;
    static int answer = Integer.MAX_VALUE;

    public static int solution(int n, int[] weak, int[] dist){
        //원형 -> 선형 2배 확장
        doubleweak = new int[weak.length * 2];
        for(int i=0;i<weak.length;i++){
            doubleweak[i] = weak[i];
            doubleweak[i+weak.length] = weak[i] + n;
        }

        friends = new ArrayList<>();
        visited = new boolean[dist.length];

        //2. dist 친구에 대해서 넣는 순서 구하기 (순열)
        dfs(0, new ArrayList<>(),dist);

        //3 구한뒤에 각 취약지점을 시작점으로 친구 투입해서 점검 가능한지 확인
        for(int i=0;i<weak.length;i++){
            for(List<Integer> friend : friends){
                int count = 1;
                int pos = weak[i] + friend.get(0);
                //취약지점 시작점을 기준 -> 거기서 weak.length까지 확인
                for(int j=i;j<i+weak.length;j++){
                    if(pos < doubleweak[j]){
                        count++;
                        if(count > friend.size()) break;
                        pos = doubleweak[j] + friend.get(count-1);
                    }
                }

                if(count <= friend.size()){
                    answer = Math.min(answer, count);
                }

            }
        }

        if(answer == Integer.MAX_VALUE) return -1;

        return answer;
    }

    static void dfs(int idx, List<Integer> path, int[] dist){
        if(idx == dist.length){
            friends.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<dist.length;i++){
            if(!visited[i]){
                visited[i] = true;
                path.add(dist[i]);
                dfs(idx+1, path, dist);
                visited[i] = false;
                path.remove(path.size()-1);
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
