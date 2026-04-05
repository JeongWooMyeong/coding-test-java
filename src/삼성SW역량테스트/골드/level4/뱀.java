package 삼성SW역량테스트.골드.level4;

import java.util.*;
import java.io.*;

/*
내가 스스로 생각하고 짠 코드 - 조금 순서와 틀린 부분 있어서 뱀2에 수정
 */

public class 뱀 {
    static int N, K, L;
    static Map<Integer, Character> map = new HashMap<>();
    static int[][] board;

    static int[] dx = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위
    static int[] dy = {1, 0, -1, 0};

    static int time = 0;

    static class Snake{
        int x, y, dir;
        public Snake(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        K = Integer.parseInt(br.readLine());

        for(int i =0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //사과 위치는 1로 표시
            board[x-1][y-1] = 1;
        }

        L = Integer.parseInt(br.readLine());

        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int times = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            map.put(times, dir);

        }

        bfs();

        System.out.print(time);
    }

    static void bfs(){
        Deque<Snake> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        Snake head = new Snake(0,0, 0);
        //Snake tail = new Snake(0,0,4);

        //queue.add(tail);
        queue.add(head);

        while(true){
            Snake s = queue.pollLast();
            int x = s.x;
            int y = s.y;
            int dir = s.dir;
            //visited[x][y] = true;

            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
            //if(visited[nx][ny]) break;
            //자기몸 충돌
            boolean hit = false;
            for(Snake ss : queue){
               if((ss.x == nx && ss.y == ny) || (ss.x == x && ss.y == y)){
                   hit = true;
                   break;
               }
            }
            if(hit) break;

            //3초가 끝난 뒤에 반영이므로 맨 마지막
            if(map.containsKey(time)) {
                if (map.get(time) == 'L') {
                    dir = (dir + 3) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }
            }

            //사과가 있다면
            if(board[nx][ny] == 1){
                board[nx][ny] = 0;
                queue.offer(new Snake(nx, ny, dir));
            }else{
                Snake tail = queue.pollFirst();
                board[tail.x][tail.y] = 0;
                queue.offer(new Snake(nx, ny, dir));

            }




        }

    }


}
