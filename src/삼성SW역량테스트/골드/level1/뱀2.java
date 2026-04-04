package 삼성SW역량테스트.골드.level1;

import java.util.*;
import java.io.*;

public class 뱀2 {
    static int N, K, L;
    static Map<Integer, Character> map = new HashMap<>();
    static int[][] board;

    static int[] dx = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위
    static int[] dy = {1, 0, -1, 0};

    static int time = 0;

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
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0});
        int dir = 0;

        while(true){
            time++;
            //뽑으면 이게 자기몸 충돌을 비교할 수 없으니 peek 가져오면 되는구나..
            int[] s = queue.peekLast();
            int x = s[0];
            int y = s[1];

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
            //if(visited[nx][ny]) break;
            //자기몸 충돌
            boolean hit = false;
            for(int[] ss : queue){
                if((ss[0] == nx && ss[1] == ny)){
                    hit = true;
                    break;
                }
            }
            if(hit) break;


            //사과가 있다면 더 직관적
            if(board[nx][ny] == 1){
                queue.offer(new int[]{nx, ny});
                board[nx][ny] = 0;
            }else{
                queue.offer(new int[]{nx, ny});
                queue.pollFirst();
            }

            //3초가 끝난 뒤에 반영이므로 맨 마지막
            if(map.containsKey(time)) {
                if (map.get(time) == 'L') {
                    dir = (dir + 3) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }
            }



        }

    }


}
