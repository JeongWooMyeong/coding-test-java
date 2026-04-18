package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
난 바로 떠오른게 위상정렬이였지만 전체 순서 집합이 아닌
부분 순서 순위 집합 관계를 보여줬기 때문에 위상정렬로 풀 수 없고
플로이드 워셜 알고리즘으로 풀어야함
X
 */

public class 순위 {
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    static int[] indegree;
    static List<Integer> result = new ArrayList<>();


    public static int solution(int n, int[][] results){
        indegree = new int[n+1];

        Arrays.fill(indegree, 0);

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        for(int[] result : results){
            int a = result[0];
            int b = result[1];

            edges.get(a).add(b);
            indegree[b] += 1;

        }

        topology_sort(n);

        return result.size();

    }

    static void topology_sort(int n){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            result.add(now);
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
                indegree[next] -= 1;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        int n = 5;
        int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};

        System.out.println(solution(n, results));
    }

}
