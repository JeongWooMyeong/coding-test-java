package 이것이코딩테스트다2.기출문제.그래프이론;

import java.util.*;
import java.io.*;

public class 여행계획 {
    static int N, M;
    static int[][] map;
    static int[] plan;
    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        parent = new int[N+1];

        //부모노드 자기 자신으로 초기화
        for(int i=1;i<=N;i++){
            parent[i] = i;
        }
        //입력할때 값이 1이면 연결되있다는 것이므로 union
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    union(i,j);
                }
            }
        }

        plan = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            plan[i] = Integer.parseInt(st.nextToken());
        }
        //plan 배열 0번째 root 찾아서
        //나머지 비교하면서 root 아니면 false;
        int root = findParent(plan[0]);
        boolean found = true;
        for(int i=1;i<M;i++){
            if(root != findParent(plan[i])){
                found = false;
                break;
            }
        }

        System.out.print(!found ? "NO" : "YES");

    }

    static int findParent(int x){
        if(parent[x] == x) return x;
        else return parent[x] = findParent(parent[x]);
    }

    static void union(int x, int y){
        int a = findParent(x);
        int b = findParent(y);

        if(b > a) parent[b] = a;
        else parent[a] = b;
    }

}
