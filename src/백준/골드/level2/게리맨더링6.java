package 백준.골드.level2;

import java.util.*;
import java.io.*;

/*
2,4번 경계구역 앞에서부터 처리하면 경계선 처리하는 방식때문에
뒤에서 하는게 보편적으로 많이 쓰임 (답이 다르게 나옴)

 */

public class 게리맨더링6 {
    static int N;
    static int[][] map;
    static int totalPeople = 0;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    // nxn
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                totalPeople += map[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (i + d1 + d2 >= N) continue;
                        if (j + d2 >= N || j - d1 < 0) continue;

                        solution(i, j, d1, d2);
                    }
                }
            }
        }

        System.out.print(result);
    }

    static void solution(int x, int y, int d1, int d2) {
        boolean[][] border = new boolean[N][N];

        // 경계선 표시
        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true;
            border[x + d2 + i][y + d2 - i] = true;
        }
        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true;
            border[x + d1 + i][y - d1 + i] = true;
        }

        int[] people = new int[5];

        // 1번 구역
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (border[i][j]) break;
                people[0] += map[i][j];
            }
        }

        // 2번 구역 (앞에서 탐색)
        for (int i = 0; i <= x + d2; i++) {
            int start = -1;
            for (int j = y + 1; j < N; j++) {
                if (border[i][j]) {
                    start = j;
                    break;
                }
            }
            if (start != -1) {
                for (int j = y + 1; j < start; j++) {
                    people[1] += map[i][j];
                }
            } else {
                for (int j = y + 1; j < N; j++) {
                    people[1] += map[i][j];
                }
            }
        }

        // 3번 구역
        for (int i = x + d1; i < N; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (border[i][j]) break;
                people[2] += map[i][j];
            }
        }

        // 4번 구역 (앞에서 탐색)
        for (int i = x + d2 + 1; i < N; i++) {
            int start = -1;
            for (int j = y - d1 + d2; j < N; j++) {
                if (border[i][j]) {
                    start = j;
                    break;
                }
            }
            if (start != -1) {
                for (int j = y - d1 + d2; j < start; j++) {
                    people[3] += map[i][j];
                }
            } else {
                for (int j = y - d1 + d2; j < N; j++) {
                    people[3] += map[i][j];
                }
            }
        }

        // 5번 구역
        int sum = 0;
        for (int i = 0; i < 4; i++) sum += people[i];
        people[4] = totalPeople - sum;

        Arrays.sort(people);
        result = Math.min(result, people[4] - people[0]);
    }
}
