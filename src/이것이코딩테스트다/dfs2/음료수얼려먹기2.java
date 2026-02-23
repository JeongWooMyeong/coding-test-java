package 이것이코딩테스트다.dfs2;

import java.util.*;

public class 음료수얼려먹기2 {
    static int n, m;
    static int[][] graph;
    public static boolean dfs(int x, int y){
        if(x <= -1 || y <= -1 || x >= n || y >= m) return false;
        if(graph[x][y] == 0){
            graph[x][y] = 1;
            dfs(x-1, y);
            dfs(x+1, y);
            dfs(x, y-1);
            dfs(x, y+1);
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n][m];

        sc.nextLine();  //버퍼 초기화

        //graph 초기화
        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            for(int j=0;j<m;j++){
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dfs(i, j)) result += 1;
            }
        }

        System.out.println(result);

    }

}
