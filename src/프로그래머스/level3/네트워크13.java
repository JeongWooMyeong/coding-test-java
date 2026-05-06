package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 네트워크13 {
    static Set<Integer> parentSet;
    static int[] parent;

    public static int solution(int n, int[][] computers){
        parentSet = new HashSet<>();
        parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        int m = computers[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(computers[i][j] == 1){
                    union(i,j);
                }
            }
        }


        for(int i=0;i<n;i++){
            parentSet.add(findParent(i));
        }




        return parentSet.size();
    }

    static int findParent(int x){
        if(parent[x] == x) return x;
        else return parent[x] = findParent(parent[x]);
    }

    static void union(int x, int y){
        int a = findParent(x);
        int b = findParent(y);

        if(b>a) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws Exception{
        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};

        System.out.println(solution(n, computers));
    }

}
