package 백준.실버.level1;

import java.util.*;

public class 숨바꼭질 {
    static final int MAX = 100001;
    static int n, k;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        visited = new boolean[MAX];

        System.out.println(bfs(n, k));
    }

    static int bfs(int n, int k){
        boolean[] visited = new boolean[MAX];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n, 0});
        visited[n] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int pos = cur[0];
            int time = cur[1];

            if(pos == k) return time;

            //이동 가능한 3가지 경우
            int[] nextMoves = { pos - 1, pos + 1, pos * 2};
            for(int next : nextMoves){
                if(next >= 0 && next < MAX && !visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next, time + 1});
                }
            }
        }

        return -1;
    }

}
