package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 외벽점검9 {

    static List<List<Integer>> friends;
    static int[] doubleweak;
    static int answer;
    static boolean[] visited;

    public static int solution(int n, int[] weak, int[] dist){
        answer = Integer.MAX_VALUE;
        //1. weak 2배로 확장
        doubleweak = new int[weak.length*2];
        for(int i=0;i<weak.length;i++){
            doubleweak[i] = weak[i];
            doubleweak[i+weak.length] = weak[i] + n;
        }

        //2. dist 배열로 친구 순열 생성
        visited = new boolean[dist.length];
        friends = new ArrayList<>();
        dfs(new ArrayList<>(), dist);

        //3. 각 weak를 시작지점으로 weak.length까지 친구 몇명이 필요한지 그리고 최소값을 구해준다.
        for(int i=0;i<weak.length;i++){
            for(List<Integer> friend : friends){
                int pos = weak[i] + friend.get(0);
                int count = 1;
                for(int j=i;j<i+weak.length;j++){
                    if(pos < doubleweak[j]){
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

        if(answer == Integer.MAX_VALUE){
            return -1;
        }

        return answer;

    }

    static void dfs( List<Integer> friend, int[] dist){

        if(friend.size() == dist.length){
            friends.add(new ArrayList<>(friend));
            return;
        }

        for(int i=0;i<dist.length;i++){
            if(!visited[i]){
                visited[i] = true;
                friend.add(dist[i]);
                dfs(friend, dist);
                visited[i] =false;
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
