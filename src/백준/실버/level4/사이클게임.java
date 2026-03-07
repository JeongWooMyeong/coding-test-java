package 백준.실버.level4;

import java.util.*;
import java.io.*;

public class 사이클게임 {
    static int n,m;
    static int[] parent;
    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        //빼먹음
        for(int i=0;i<n;i++) parent[i] = i;
//        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //union(a,b);

            if(findParent(a) == findParent(b)){
                result = i + 1;
                break;
            }else{
                union(a,b);
            }


        }

        System.out.print(result);
    }
    static int findParent(int x){
        if(x == parent[x]) return x;
        else return parent[x] = findParent(parent[x]);
    }

    static void union(int x, int y){
        int a = findParent(x);
        int b = findParent(y);

        if(b>a) parent[b] = a;
        else parent[a] = b;

    }

}
