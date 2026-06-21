package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 외벽점검11 {

    static int answer;
    static int[] doubleweak;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> friends;

    public static int solution(int n, int[] weak, int[] dist){
        doubleweak = new int[weak.length * 2];
        answer = Integer.MAX_VALUE;
        visited = new boolean[dist.length];
        friends = new ArrayList<>();

        //외벽 2배 확장
        for(int i=0;i<weak.length;i++){
            doubleweak[i] = weak[i];
            doubleweak[i+weak.length] = weak[i] + n;
        }

        //친구 순열 생성
        dfs(new ArrayList<>(), dist);

        //친구 순열 돌면서 친구 확인
        for(int i=0;i<weak.length;i++){
            for(List<Integer> friend : friends){
                int pos = weak[i] + friend.get(0);
                int count = 1;
                for(int j=i;j<i+weak.length;j++){
                    if(pos < doubleweak[j]){
                        count++;
                        if(count > dist.length) break;
                        //새 친구 시작점
                        pos = doubleweak[j] + friend.get(count-1);
                    }
                }
                if(count <= dist.length){
                    answer = Math.min(answer, count);
                }
            }
        }

        if(answer == Integer.MAX_VALUE) return -1;

        return answer;

    }

    static void dfs(ArrayList<Integer> friend, int[] dist){
        if(friend.size() == dist.length){
            friends.add(new ArrayList<>(friend));
            return;
        }

        for(int i=0;i<dist.length;i++){
            if(!visited[i]){
                visited[i] = true;
                friend.add(dist[i]);
                dfs(friend, dist);
                visited[i] = false;
                friend.remove(friend.size()-1);
            }
        }

    }

    public static void main(String[] args) throws Exception{
        int n = 12;
        int[] weak = {1,5,6,10};
        int[] dist = {1,2,3,4};

        System.out.println(solution(n,weak,dist));
    }

}
