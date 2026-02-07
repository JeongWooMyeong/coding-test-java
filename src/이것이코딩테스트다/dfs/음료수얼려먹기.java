package 이것이코딩테스트다.dfs;

import java.util.*;

public class 음료수얼려먹기 {
    static int n,m;
    static int[][] graph;

    //dfs 함수
    public static boolean dfs(int x, int y){
        //범위를 벗어나면 false
        if(x < 0 || x>= n || y < 0 || y >= m){
            return false;
        }
        //현재 위치가 '0'이면 (얼음 칸)
        if(graph[x][y] == 0){
            graph[x][y] = 1; //방문 처리 (1로 바꿔버림)

            //상하좌우 재귀 호출
            dfs(x-1, y);
            dfs(x+1, y);
            dfs(x, y-1);
            dfs(x, y+1);

            return true;

        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); //버퍼 비우기

        graph = new int[n][m];

        //얼음 틀 입력
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        int result = 0;
        //모든 칸 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
