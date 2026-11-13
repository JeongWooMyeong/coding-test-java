package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 프렌즈4블록10 {

    static char[][] map;
    static boolean[][] results;
    static int answer;


    public static int solution(int m, int n, String[] board){

        map = new char[m][n];
        answer = 0;

        for(int i=0;i<board.length;i++){
            String line = board[i];
            for(int j=0;j<line.length();j++){
                map[i][j] = line.charAt(j);
            }
        }

        while(true){
            boolean found = false;
            results = new boolean[m][n];

            for(int i=0;i<map.length-1;i++){
                for(int j=0;j<map[i].length-1;j++){
                    char c = map[i][j];

                    if(c == '.') continue;

                    if(map[i+1][j] == c && map[i][j+1] == c && map[i+1][j+1] == c){
                        results[i][j] = true;
                        results[i+1][j] = true;
                        results[i][j+1] = true;
                        results[i+1][j+1] = true;
                        found = true;

                    }

                }
            }

            if(!found) break;

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(results[i][j]){
                        answer += 1;
                        map[i][j] = '.';
                    }
                }
            }

            for(int j=0;j<n;j++){
                for(int i=m-1;i>0;i--) {
                    if (map[i][j] == '.') {
                        int idx = i - 1;
                        char temp = map[i][j];

                        while (idx >= 0 && map[idx][j] == '.') {
                            idx--;
                        }

                        if (idx >= 0) {
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
        String[] board = {"CCBDE","AAADE","AAABF","CCBBF"};

        System.out.println(solution(m,n,board));

    }

}
