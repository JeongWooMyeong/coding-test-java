package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 외벽점검5 {
    static boolean[] visited;
    static List<List<Integer>> friends;
    static int[] doubleweak;
    static int answer = Integer.MAX_VALUE;

    public static int solution(int n, int[] weak, int[] dist){
        doubleweak = new int[weak.length*2];
        friends = new ArrayList<>();
        visited = new boolean[dist.length];
        //1. 원형 선형 2배 확장
        for(int i=0;i<weak.length;i++){
            doubleweak[i] = weak[i];
            doubleweak[i+weak.length] = weak[i] + n;
        }

        //2. 친구 선택 경우의 수 구하기
        dfs(0, new ArrayList<>(), dist);
        
        //3. 취약지점 시작점으로 하면서 최소 친구 수 구하기
        for(int i=0;i<weak.length;i++){
            for(List<Integer> friend : friends){

                //시작 지점 선택
                int count = 1;
                int pos = weak[i] + friend.get(0);
                //돌면서 친구 필요한지 확인
                for(int j=i;j<i+weak.length;j++){
                    if(doubleweak[j] > pos){
                        count++;
                        if(count > friend.size()) break;
                        pos = doubleweak[j] + friend.get(count-1);
                    }
                }

                if(count <= friend.size()){
                    answer =Math.min(answer, count);
                }

            }
        }

        if(answer == Integer.MAX_VALUE) return -1;

        return answer;
    }

    static void dfs(int idx, List<Integer> friend, int[] dist){
        if(idx == dist.length){
            friends.add(new ArrayList<>(friend));
            return;
        }

        for(int i=0;i<dist.length;i++){
            if(!visited[i]){
                visited[i] = true;
                friend.add(dist[i]);
                dfs(idx + 1, friend, dist);
                visited[i] = false;
                friend.remove(friend.size()-1);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        int n = 12;
        int[] weak = {1,3,4,9,10};
        int[] dist = {3,5,7};

        System.out.println(solution(n, weak, dist));
    }

}
