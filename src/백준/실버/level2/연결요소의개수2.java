package 백준.실버.level2;

import java.util.*;

public class 연결요소의개수2 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n+1]; //정점 개수 +1

        //x좌표 초기화
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int count = 0;
        //1부터 시작이므로 0부터 시작할 필요 없음
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }

        System.out.print(count);


    }

    public static void dfs(int x){
        visited[x] = true;
        for(int i=0;i<graph.get(x).size();i++){
            int y = graph.get(x).get(i);
            if(!visited[y]){
                dfs(y);
            }
        }
    }
}
