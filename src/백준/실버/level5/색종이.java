package 백준.실버.level5;

import java.io.*;
import java.util.*;

public class 색종이 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    //색종이 개수
        int[][] paper = new int[100][100];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //색종이 영역 칠하기
            for(int r = y; r < y + 10;r++){
                for(int c = x;c<x+10;c++){
                    paper[r][c] = 1;
                }
            }
        }

        //넓이 계산
        int area = 0;
        for(int r=0;r<100;r++){
            for(int c =0;c<100;c++){
                if(paper[r][c] == 1) area++;
            }
        }

        System.out.println(area);
    }
}
