package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 프렌즈4블록3 {
    static boolean[][] remove;
    static char[][] map;
    static int answer;

    public static int solution(int m, int n, String[] board){
        map = new char[m][n];
        answer = 0;
        //1. String char 2차원배열로 담기
        for(int i=0;i<m;i++){
            String line = board[i];
            for(int j=0;j<line.length();j++){
                map[i][j] = line.charAt(j);
            }
        }

        //2. while문 돌면서 2x2 제거 반복 (제거할 대상 없을때 종료)
        while(true){
            boolean found = false;
            remove = new boolean[m][n];
            //3. 2x2 제거 확인 (같은 모양, 마지막 행 제외, 빈칸도 제외)
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    char c = map[i][j];
                    //빈칸이면 넘어감 (빈칸은 '.' 로 정함
                    if(c == '.') continue;

                    //시작기준 오른쪽, 오른쪽대각선, 아래가 c와 같으면 2x2 성립
                    if(map[i+1][j] == c && map[i+1][j+1] == c && map[i][j+1] == c){
                        remove[i][j] = true;
                        remove[i+1][j] = true;
                        remove[i+1][j+1] = true;
                        remove[i][j+1] = true;
                        found = true;
                    }

                }
            }

            //4. 찾지 못했으면 반복 종료
            if(!found) break;

            //5. 찾았으면 찾은 거 빈칸 만들기
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(remove[i][j]){
                        map[i][j] = '.';
                        answer++;   //제거 칸 개수 세기
                    }
                }
            }

            //6. 제거 후 빈칸으로 이동 (행기준으로 내려감)
            for(int j=0;j<n;j++){
                for(int i=m-1;i>=0;i--){
                    //for문 돌면서 빈칸이면
                    if(map[i][j] == '.'){
                        //K는 i랑 같으면 안되므로 위로 올라감
                        int k = i-1;
                        //k가 0보다 크거나 같고 '.' 일때만 whlil문 시행
                        //이동처리할때 k인데 왜 i로 했지...
                        while(k >= 0 && map[k][j] == '.'){
                            k--;
                        }
                        //즉 빈칸이 아닌 값이 나오고 k>=0 이상일땐
                        if(k >= 0) {
                            //빈칸에 해당 값넣어주고
                            map[i][j] = map[k][j];
                            //해당 값에는 빈칸 넣어줌
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
