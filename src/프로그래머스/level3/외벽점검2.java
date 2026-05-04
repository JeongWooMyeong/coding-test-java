package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 외벽점검2 {
    static List<List<Integer>> friends;
    static boolean[] visited;
    static int[] doubleweak;
    static int answer = Integer.MAX_VALUE;

    public static int solution(int n, int[] weak, int[] dist){
        friends = new ArrayList<>();
        doubleweak = new int[weak.length*2];
        visited = new boolean[dist.length];

        for(int i=0;i<weak.length;i++){
            doubleweak[i] = weak[i];
            doubleweak[i+weak.length] = n + weak[i];
        }

        dfs(0, dist, new ArrayList<>());

        for(int i=0;i<weak.length;i++){
            for(List<Integer> friend : friends){
                int count = 1;
                int pos = doubleweak[i] + friend.get(0);

                int j;
                for(j=i;j<i+weak.length;j++){
                    if(doubleweak[j] > pos){
                        count++;
                        if(count > friend.size()) break;
                        //취약지점에서 더해야한다? 잘못생각했네 누적합이 아니구나..
                        pos = doubleweak[j] + friend.get(count-1);
                    }
                }

                if(j == i+weak.length) answer = Math.min(answer, count);

            }
        }

        if(answer == Integer.MAX_VALUE) return -1;

        return answer;

    }

    static void dfs(int idx, int[] dist, List<Integer> selected){
        if(idx == dist.length){
            friends.add(new ArrayList<>(selected));
            return;
        }

        for(int i=0;i<dist.length;i++){
            if(!visited[i]){
                visited[i] = true;
                selected.add(dist[i]);
                dfs(idx+1, dist, selected);
                selected.remove(selected.size()-1);
                visited[i] = false;
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
