package 백준.골드.level5;

import java.util.*;
import java.io.*;

/*
완벽한 코드라고 보기 어려움
 */

public class 토마토5 {
    static int N, M, H;
    static int[][] board;
    static int days = 0;

    // 6방향: 상, 하, 좌, 우, 위층(-N), 아래층(+N)
    static int[] dx;
    static int[] dy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행
        H = Integer.parseInt(st.nextToken()); // 층

        board = new int[N * H][M];
        Queue<int[]> q = new ArrayDeque<>();

        // 방향 벡터 정의 (층 이동을 행 점프로 처리)
        dx = new int[]{-1, 1, 0, 0, -N, N};
        dy = new int[]{0, 0, -1, 1, 0, 0};

        // 입력: N*H 행을 순서대로 읽음
        for (int i = 0; i < N * H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        days = bfs(q);

        // 결과 판정
        for (int i = 0; i < N * H; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(days);
    }

    static int bfs(Queue<int[]> q) {
        int days = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                for (int i = 0; i < 6; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N * H || ny >= M) continue;
                    if (board[nx][ny] == -1) continue;

                    if (board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            if (!q.isEmpty()) days++;
        }
        return days;
    }
}
