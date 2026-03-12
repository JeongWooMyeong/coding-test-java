package 백준.골드.level4;

import java.io.*;
import java.util.*;

public class 테트로미노 {
    static int n,m;
    static int[][] board;

    //기본 테트로미노 모양 정의 (5개)
    static int[][][] baseShapes = {
            // I
            {{0,0},{0,1},{0,2},{0,3}},
            // O
            {{0,0},{0,1},{1,0},{1,1}},
            // L
            {{0,0},{1,0},{2,0},{2,1}},
            // S
            {{0,1},{0,2},{1,0},{1,1}},
            // T
            {{0,0},{0,1},{0,2},{1,1}}

    };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                for (int[][] shape : baseShapes) {
                    //회전 4번, 대칭 2번 -> 모든 경우
                    for(int r=0;r<4;r++){
                        int[][] rotated = rotate(shape, r);
                        maxSum = Math.max(maxSum, calcSum(i, j, rotated));
                        int[][] flipped = flip(rotated);
                        maxSum = Math.max(maxSum, calcSum(i, j, flipped));
                    }
                }
            }
        }

        System.out.println(maxSum);
    }

    //90도 회전 r번
    static int[][] rotate(int[][] shape, int r){
        int[][] res = new int[shape.length][2];
        for(int i=0;i<shape.length;i++){
            int x = shape[i][0], y = shape[i][1];
            for(int k=0;k<r;k++){
                int tmp = x;
                x = y;
                y = -tmp;
            }
            res[i][0] = x;
            res[i][1] = y;

        }
        return normalize(res);
    }

    //좌우대칭
    static int[][] flip(int[][] shape){
        int[][] res = new int[shape.length][2];
        for(int i=0;i<shape.length;i++){
            res[i][0] = shape[i][0];
            res[i][1] = -shape[i][1];
        }
        return normalize(res);
    }

    //좌표를 (0, 0) 기준으로 정규화
    static int[][] normalize(int[][] shape){
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for(int[] p : shape){
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);

        }
        int[][] res = new int[shape.length][2];
        for(int i=0;i<shape.length;i++){
            res[i][0] = shape[i][0] - minX;
            res[i][1] = shape[i][1] - minY;
        }
        return res;
    }

    //합 계산
    static int calcSum(int x, int y, int[][] shape){
        int sum = 0;
        for(int[] p : shape){
            int nx = x + p[0];
            int ny = y + p[1];
            if(nx < 0 || nx >=n || ny < 0 || ny >= m) return 0;
            sum += board[nx][ny];   //ㅎㅂ 게산
        }
        return sum;
    }

}
