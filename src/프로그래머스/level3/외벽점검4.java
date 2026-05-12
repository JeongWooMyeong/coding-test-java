package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 외벽점검4 {
    static int[] doubleweak;
    static boolean[] visited;
    static List<List<Integer>> friends;
    static int answer = Integer.MAX_VALUE;

    public static int solution(int n, int[] weak, int[] dist){
        doubleweak = new int[weak.length*2];
        //1. 좌표 2배 확장
        for(int i=0;i<weak.length;i++){
            doubleweak[i] = weak[i];
            doubleweak[i+weak.length] = weak[i] + n;
        }

        visited = new boolean[dist.length];
        friends = new ArrayList<>();

        //2. 친구 선택하는 모든 경우의 수 구하기
        dfs(0, new ArrayList<>(), dist);

        //3, weak 취약지점을 시작점으로 하나씩 돌면서 친구 확인
        for(int i=0;i<weak.length;i++){
            for(List<Integer> friend : friends){
                //첫 지점을 start로 잡고 진행
                int count = 1;
                int pos = weak[i] + friend.get(0);
                //실수 - 시작점부터 시작점부터 4개지점
                for(int j=i;j<i+weak.length;j++){
                    if(doubleweak[j] > pos) {
                        count++;
                        if (count > friend.size()) break;
                        pos = doubleweak[j] + friend.get(count - 1);
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

    static void dfs(int idx, List<Integer> friend, int[] dist){
        if(idx == dist.length){
            //실수
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
        int[] weak = {1,5,6,10};
        int[] dist = {1,2,3,4};

        System.out.println(solution(n, weak, dist));
    }

}
