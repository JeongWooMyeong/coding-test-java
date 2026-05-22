package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 외벽점검7 {

    static int[] doubleweak;
    static ArrayList<ArrayList<Integer>> friends;
    static boolean[] visited;

    public static int solution(int n, int[] weak, int[] dist){
        int answer = Integer.MAX_VALUE;
        doubleweak = new int[weak.length * 2];
        friends = new ArrayList<>();
        //1. 취약지점 -> 2배 확장
        for(int i=0;i<weak.length;i++){
            doubleweak[i] = weak[i];
            doubleweak[i+weak.length] = weak[i] + n;
        }

        visited = new boolean[dist.length];
        //2. dist 친구에 대한 순열 경우의 수 구하기
        dfs(0, new ArrayList<>(), dist);

        //3. weak를 시작지점으로 한 커버 가능한 친구 최소 수 구하기
        for(int i=0;i<weak.length;i++){
            for(List<Integer> friend : friends){
                int count = 1;  //시작 지점 친구 한명 시작
                int pos = weak[i] + friend.get(0);

                //weak 시작지점 기점으로 weak.length까지 범위
                for(int j=i;j<i+weak.length;j++){
                    //현재 커버범위보다 취약지점이 크다면 갱신
                    if(doubleweak[j] > pos){
                        count++;    //친구수 증가
                        //만약 친구수가 넘어가면 종료
                        if(count > dist.length) break;
                        //커버범위 갱신
                        pos = doubleweak[j] + friend.get(count-1);
                    }
                }

                if(count <= dist.length){
                    answer = Math.min(answer, count);
                }

            }
        }
        //만약 갱신 안됐다면 max_VALUE 그대로
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
                dfs(idx+1, friend, dist);
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
