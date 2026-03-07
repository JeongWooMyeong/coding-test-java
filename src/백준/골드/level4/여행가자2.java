package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 여행가자2 {
    static int n,m; //입력
    static int[] parent;    //부모노드
    static int[] schedule;  //여행계획 배열

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        //속한 속한 속한
        parent = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }

        //인접행렬을 넣는게 아니고 입력 방식으로 사용하면 되네,,
        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                int connected = Integer.parseInt(st.nextToken());
                if(connected == 1) union(i,j);
            }
        }

        schedule = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            schedule[i] = Integer.parseInt(st.nextToken());
        }

        boolean possible = true;
        int root = findParent(schedule[0]);

        for(int i=1;i<m;i++){
            if(root != findParent(schedule[i])){
                possible = false;
                break;
            }
        }

        System.out.print(possible ? "YES" : "NO");
    }

    static int findParent(int x){
        if(x == parent[x]) return x;
        else return parent[x] = findParent(parent[x]);
    }

    static void union(int x, int y){
        int a = findParent(x);
        int b = findParent(y);

        if(b > a) parent[b] = a;
        else parent[a] = b;
    }

}
