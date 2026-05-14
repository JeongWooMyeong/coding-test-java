package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 프렌즈4블록5 {
    //빈칸 처리 여부 2x2
    static boolean[][] result;
    static char[][] map;

    public static int solution(int m, int n, String[] board){
        map = new char[m][n];
        int answer = 0;
        //이차원 배열 map 담기
        for(int i=0;i<m;i++){
            String line = board[i];
            for(int j=0;j<n;j++){
                map[i][j] = line.charAt(j);
            }
        }
        while(true) {
            boolean found = false;
            result = new boolean[m][n];
            //이차원 배열 map 돌면서 2x2 체크
            //마지막 행, 열은 제외 (2x2 체크 할수 없음)
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = map[i][j];
                    //빈칸은 처리 하면 안되므로 넘김
                    if(c == '.') continue;

                    //오른쪽,아래, 대각선 다 같아여 2x2 성립
                    if (c == map[i + 1][j] && c == map[i][j + 1] && c == map[i + 1][j + 1]) {
                        result[i][j] = true;
                        result[i + 1][j] = true;
                        result[i][j + 1] = true;
                        result[i + 1][j + 1] = true;
                        found = true;
                    }

                }
            }

            if(!found) break;

            //빈칸 처리
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (result[i][j]) {
                        map[i][j] = '.';
                        answer++;
                    }
                }
            }

            //빈칸 처리 후 이동 아래로 이동해야하므로 아래서부터 진행하는게 좋을듯
            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] == '.') {
                        int idx = i - 1;
                        //char temp = map[i][j];
                        while (idx >= 0 && map[idx][j] == '.') {
                            idx--;
                        }
                        if (idx >= 0) {
                            char temp = map[i][j];
                            map[i][j] = map[idx][j];
                            map[idx][j] = temp;
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

        String[] board ={"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(m,n,board));
    }

}
