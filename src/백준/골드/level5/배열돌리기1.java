package 백준.골드.level5;

import java.io.*;
import java.util.*;

public class 배열돌리기1 {
    // 방향 벡터: 오른쪽, 아래, 왼쪽, 위
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열
        int R = Integer.parseInt(st.nextToken()); // 회전 횟수

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layers = Math.min(N, M) / 2; // 겹(layer) 개수

        // 각 레이어를 회전
        for (int layer = 0; layer < layers; layer++) {
            rotate(arr, N, M, R, layer);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    // 특정 레이어를 회전시키는 메서드
    private static void rotate(int[][] arr, int N, int M, int R, int layer) {
        int top = layer, left = layer;
        int bottom = N - 1 - layer, right = M - 1 - layer;

        // 현재 레이어 원소 개수
        int size = 2 * (bottom - top + right - left);
        int rotate = R % size; // 실제 회전 횟수

        // 레이어 원소를 리스트로 추출
        List<Integer> list = new ArrayList<>();
        int x = top, y = left;
        int dir = 0; // 방향 인덱스

        while (true) {
            list.add(arr[x][y]);
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 범위를 벗어나면 방향 전환
            if (nx < top || nx > bottom || ny < left || ny > right) {
                dir++;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            // 시작점으로 돌아오면 종료
            if (nx == top && ny == left) break;

            x = nx;
            y = ny;
        }

        // 회전된 결과를 다시 채워 넣기
        int idx = rotate;
        x = top; y = left; dir = 0;
        while (true) {
            arr[x][y] = list.get(idx++ % size);
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < top || nx > bottom || ny < left || ny > right) {
                dir++;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            if (nx == top && ny == left) break;

            x = nx;
            y = ny;
        }
    }

}
