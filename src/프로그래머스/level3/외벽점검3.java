package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 외벽점검3 {
    static int[] dweak;
    static boolean[] visited;
    static List<List<Integer>> friends;

    public static int solution(int n, int[] weak, int[] dist){
        int answer = Integer.MAX_VALUE;
        dweak = new int[weak.length*2];
        for(int i=0;i<weak.length;i++){
            dweak[i] = weak[i];
            dweak[i+weak.length] = weak[i] + n;
        }

        visited = new boolean[dist.length];
        friends = new ArrayList<>();
        //친구 선택할 수있는 순서 경우의 수 구하기
        dfs(0, dist, new ArrayList<>());

        //취약지점 하나씩 시작지점으로 하고 커버 가능한 최소 지점 구하기
        for(int i=0;i<weak.length;i++){
            for(List<Integer> friend : friends){
                int count = 1;
                int pos = dweak[i] + friend.get(0);
                //범위 제한 틀렸네.. 아 맞네 시작지점부터 4개지점 커버니까..
                for(int j=i;j<i+weak.length;j++){
                    if(dweak[j] > pos){
                        count++;
                        if(count > friend.size()) break;
                        pos = dweak[j] + friend.get(count-1);
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

    static void dfs(int idx, int[] dist, List<Integer> friend){
        if(idx == dist.length){
            friends.add(new ArrayList<>(friend));
            return;
        }

        for(int i=0;i<dist.length;i++){
            if(!visited[i]){
                visited[i] = true;
                friend.add(dist[i]);
                dfs(idx +1, dist, friend);
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
