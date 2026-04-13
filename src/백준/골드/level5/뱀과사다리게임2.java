package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 뱀과사다리게임2 {
    static int N, M;
    static int[] board = new int[101]; //1차원 배열이면 충분
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //사다리 개수
        M = Integer.parseInt(st.nextToken());   //뱀의 개수
        //보드 칸 초기화
        for(int i=1;i<=100;i++){
            board[i] = i;
        }
        //사다리 정보 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x] = y;
        }

        //뱀의 정보
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x] = y;
        }

        System.out.print(bfs());

    }

    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1,0});    //시작 위치 pos, 주사위 굴린 횟수 cnt
        visited[1] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int pos = cur[0];
            int cnt = cur[1];

            if(pos == 100) return cnt;

            for(int dice=1;dice<=6;dice++){
                int next = pos + dice;
                if(next > 100) continue;
                //board값으로 해야 현재 위치 알 수 있음
                int npos = board[next];
                if(!visited[next]){
                    q.offer(new int[]{npos, cnt+1});
                    visited[next] = true;
                }
            }

        }
        return -1;
    }



}
