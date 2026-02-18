package 이것이코딩테스트다.기출문제.크루스칼최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 탑승구 {
    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        parent = new int[G+1];
        for(int i=0;i<=G;i++) parent[i] = i;

        int P = Integer.parseInt(br.readLine());
        int idx = 0;
        for(idx=0;idx<P;idx++){
            int curr = Integer.parseInt(br.readLine());
            int gate = find(curr);
            if(gate == 0) break;
            union(gate-1, gate);
        }
        System.out.println(idx);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }

    static int find(int a){
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }
}
