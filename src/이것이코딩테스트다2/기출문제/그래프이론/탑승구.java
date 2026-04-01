package 이것이코딩테스트다2.기출문제.그래프이론;

import java.util.*;
import java.io.*;

public class 탑승구 {
    static int G, P;
    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());    //탑승 구의 수
        P = Integer.parseInt(br.readLine());    //비행기의 수

        parent = new int[G+1];
        for(int i=1;i<=G;i++){
            parent[i] = i;
        }

        int result = 0;
        for(int i=0;i<P;i++){
            int S = Integer.parseInt(br.readLine());
            int root = findParent(S);

            if(root == 0) break;
            union(root, root -1);   //인접한 탑승구 union
            result++;

        }

        System.out.print(result);
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

}
