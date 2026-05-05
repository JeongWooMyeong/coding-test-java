package 프로그래머스.level2;

public class 프렌즈4블록2 {

    public static int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        int answer = 0;

        while (true) {
            boolean[][] remove = new boolean[m][n];
            boolean found = false;

            // 1. 2x2 같은 블록 찾기
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = map[i][j];
                    if (c == '.') continue;

                    if (map[i][j + 1] == c &&
                            map[i + 1][j] == c &&
                            map[i + 1][j + 1] == c) {

                        remove[i][j] = true;
                        remove[i][j + 1] = true;
                        remove[i + 1][j] = true;
                        remove[i + 1][j + 1] = true;
                        found = true;
                    }
                }
            }

            if (!found) break;

            // 2. 삭제 + 카운트
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (remove[i][j]) {
                        map[i][j] = '.';
                        answer++;
                    }
                }
            }

            // 3. 중력 적용 (아래로 떨어뜨리기)
            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] == '.') {
                        int k = i - 1;
                        while (k >= 0 && map[k][j] == '.') {
                            k--;
                        }
                        if (k >= 0) {
                            map[i][j] = map[k][j];
                            map[k][j] = '.';
                        }
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(m,n,board));
    }

}
