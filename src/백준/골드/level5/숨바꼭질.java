package 백준.골드.level5;


import java.util.*;
import java.io.*;

public class 숨바꼭질 {
    static int N, K;
    static int[] dist = new int[100001];static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    static int bfs(int n, int k){
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(n);
        Arrays.fill(dist, -1);
        dist[n] = 0;

        while(!q.isEmpty()){
            int cur = q.pollFirst();
            int time = dist[cur];

            if(cur == k) return time;

            int[] nextToken = {cur + 1, cur - 1, cur * 2};

            for(int i=0;i<nextToken.length;i++){
                if(nextToken[i] >= 0 && nextToken[i] <= 100000 && dist[nextToken[i]] == -1){
                    if(i != 2){
                        dist[nextToken[i]] = time + 1;
                        q.addLast(nextToken[i]);
                    }else{
                        dist[nextToken[i]] = time;
                        q.addFirst(nextToken[i]);
                    }

                }
            }

        }
        return - 1;
    }



}
