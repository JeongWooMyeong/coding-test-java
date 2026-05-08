package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 프렌즈4블록4 {
    static char[][] map;
    static boolean[][] result;

    public static int solution(int m, int n, String[] board){
        map = new char[m][n];
        int answer = 0;

        for(int i=0;i<m;i++){
            String line = board[i];
            for(int j=0;j<n;j++){
                map[i][j] = line.charAt(j);
            }
        }
        while(true) {
            boolean found = false;
            result = new boolean[m][n];
            //빈칸 찾기 (2x2 만족하는 배열)
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = map[i][j];
                    //빈칸 제거..
                    if(c == '.') continue;

                    if (map[i + 1][j] == c && map[i][j + 1] == c && map[i+1][j+1] == c){
                        result[i][j] = true;
                        result[i+1][j] = true;
                        result[i][j+1] = true;
                        result[i+1][j+1] = true;
                        found = true;
                    }

                }
            }

            //빈칸 없으면 종료
            if(!found) break;

            //찾은 빈칸 '.' 변경
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(result[i][j]){
                        map[i][j] = '.';
                        answer++;
                    }
                }
            }

            //빈칸 만들고 각 칸 이동
            for(int j=0;j<n;j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if(map[i][j] == '.'){
                        char temp = map[i][j];
                        int k = i-1;
                        while(k >= 0 && map[k][j] == '.'){
                            k--;
                        }
                        if(k >= 0) {
                            map[i][j] = map[k][j];
                            map[k][j] = temp;
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
