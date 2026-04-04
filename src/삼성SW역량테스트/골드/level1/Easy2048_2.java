package 삼성SW역량테스트.골드.level1;

import java.util.*;
import java.io.*;

public class Easy2048_2 {
    static int N;
    static int[][] map;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, map);

        System.out.print(max);

    }

    static void dfs(int depth, int[][] curBoard){
        if(depth == 5){
            max = Math.max(max, getMax(curBoard));
            return;
        }

        for(int dir=0;dir<4;dir++){
            int[][] newBoard = move(curBoard, dir);
            dfs(depth+1, newBoard);
        }
    }

    static int getMax(int[][] curBoard){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                max = Math.max(max, curBoard[i][j]);
            }
        }

        return max;
    }

    static int[][] move(int[][] curBoard, int dir){
        int[][] newBoard = new int[N][N];
        for(int i=0;i<N;i++) newBoard[i] = curBoard[i].clone();

        switch(dir){
            //위 일때 x만 이동
            case 0:
                for(int j=0;j<N;j++){
                    int[] line = new int[N];    //라인 값
                    int prev = 0;   //이전 값
                    int idx = 0;    //index
                    for(int i=0;i<N;i++){
                        //빈값일때 continue;
                        if(newBoard[i][j] == 0) continue;
                        if(prev == 0){
                            prev = newBoard[i][j];
                        }else{
                            //이전 값이 0이 아니고 현재 값과 같을때 (같은 숫자여야함 *2)
                            if(prev == newBoard[i][j]){
                                line[idx++] = prev * 2;
                                //합치면 이전값 0으로 초기화
                                prev = 0;
                            }else{
                                //값이 다를때에는 합치지 않음
                                line[idx++] = prev;
                                prev = newBoard[i][j];
                            }
                        }
                    }
                    //끝나고 prev가 0이 아닐경우 써준다
                    if(prev != 0) line[idx] = prev;
                    //다시 채운다
                    for(int i=0;i<N;i++) newBoard[i][j] = line[i];
                }
                break;
            //아래 방향일때는 밑에서부터 차곡차곡
            case 1:
                for(int j=0;j<N;j++){
                    //값 담을 임시 배열
                    int[] line = new int[N];
                    int prev = 0;
                    int idx = N-1;

                    for(int i=N-1;i>=0;i--){
                        //0은 빈칸이기에 제외
                        if(newBoard[i][j] == 0) continue;
                        if(prev == 0){
                            prev = curBoard[i][j];
                        }else{
                            if(prev == newBoard[i][j]){
                                line[idx--] = prev * 2;
                                //합치면 이전값 0으로 초기화
                                prev = 0;
                            }else{
                                line[idx--] = prev;
                                prev = newBoard[i][j];
                            }

                        }
                    }

                    if(prev != 0) line[idx] = prev;
                    for(int i=0;i<N;i++) newBoard[i][j] = line[i];

                }
                break;
            //좌
            case 2:
                for(int i=0;i<N;i++){
                    int[] line = new int[N];
                    int idx = 0;
                    int prev = 0;
                    for(int j=0;j<N;j++){
                        if(newBoard[i][j] == 0) continue;
                        if(prev == 0){
                            prev = newBoard[i][j];
                        }else{
                            if(newBoard[i][j] == prev) {
                                line[idx++] = prev * 2;
                                //합치면 이전값 0으로 초기화
                                prev = 0;
                            }else{
                                line[idx++] = prev;
                                prev = newBoard[i][j];
                            }
                        }
                    }

                    if(prev != 0 ) line[idx] = prev;
                    for(int j=0;j<N;j++) newBoard[i][j] = line[j];
                }
                break;
            //우
            case 3:
                for(int i=0;i<N;i++){
                    int[] line = new int[N];
                    int prev = 0;
                    int idx = N-1;
                    for(int j=N-1;j>=0;j--){
                        if(newBoard[i][j] == 0) continue;
                        if(prev == 0){
                            prev = newBoard[i][j];
                        }else{
                            if(prev == newBoard[i][j]){
                                line[idx--] = prev * 2;
                                //합치면 이전값 0으로 초기화
                                prev = 0;
                            }else{
                                line[idx--] = prev;
                                prev = newBoard[i][j];
                            }
                        }
                    }

                    if(prev != 0) line[idx] = prev;
                    for(int j=0;j<N;j++) newBoard[i][j] = line[j];
                }
                break;
        }

        return newBoard;

    }

}
