package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
find - union
전력망 연결 관계 간선으로 담고
idx를 끊을 간선 인덱스
그래서 idx일때는 continue하고 나머지 간선들 넣고
개수 세면 끊은 간선 나오고
n - 개수 -> 나머지 개수
 */

public class 전력망둘로나누기 {
    static int[] parent;
    static ArrayList<Edge> edges;

    static class Edge {
        int a;
        int b;
        public Edge(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    public static int solution(int n, int[][] wires){
        int answer = Integer.MAX_VALUE;

        int idx = 0;
        while(idx < n-1){
            edges = new ArrayList<>();
            parent = new int[n+1];
            for(int i=1;i<=n;i++){
                parent[i] = i;
            }

            for(int i=0;i<n-1;i++){
                if(idx == i) continue;
                int a = wires[i][0];
                int b = wires[i][1];
                edges.add(new Edge(a,b));
            }

            for(int i=0;i<edges.size();i++){
                int a = edges.get(i).a;
                int b = edges.get(i).b;

                if(findParent(a) != findParent(b)){
                    union(a, b);
                }

            }

            int[] count = new int[n+1];
            for(int i=1;i<=n;i++){
                count[findParent(i)]++;
            }

            ArrayList<Integer> sizes = new ArrayList<>();

            for(int i=1;i<=n;i++){
                if(count[i] > 0){
                    sizes.add(count[i]);
                }
            }

            int diff = Math.abs(sizes.get(0) - sizes.get(1));;

            answer = Math.min(answer , diff);
            idx++;
        }

        return answer;
    }

    static int findParent(int x ){
        if(parent[x] == x ) return x;
        else return parent[x] = findParent(parent[x]);
    }

    static void union(int x, int y){
        int a =  findParent(x);
        int b = findParent(y);

        if(b>a) parent[b] = a;
        else parent[a] = b;


    }

    public static void main(String[] args) throws Exception{
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        System.out.println(solution(n, wires));
    }

}
