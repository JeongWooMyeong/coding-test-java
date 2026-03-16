package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 경사로 {
    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //지도 크기
        L = Integer.parseInt(st.nextToken());   //경사로 길이
        map = new int[N][N];

        //지도 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        //1.행검사
        for(int i=0;i<N;i++){
            int[] line = new int[N];
            for(int j=0;j<N;j++) line[j] = map[i][j];
            if(canGo(line)) answer++;
        }

        //2. 열검사
        for(int j=0;j<N;j++){
            int[] line = new int[N];
            for(int i=0;i<N;i++) line[i] = map[i][j];
            if(canGo(line)) answer++;
        }

        System.out.println(answer);

    }

    //한줄(line)이 지나갈 수 있는지 판정
    static boolean canGo(int[] line){
        boolean[] slope = new boolean[N];   //경사로 설치 여부

        for(int i=0;i<N-1;i++){
            //높이 같으면 계속 진행
            if(line[i] == line[i+1]) continue;

            //높이 차가 2 이상이면 불가능
            if(Math.abs(line[i] - line[i+1]) > 1) return false;

            //내리막 (앞으로 L칸 검사)
            if(line[i] > line[i+1]){
                for(int j=i+1;j<=i+L;j++){
                    if(j >= N || line[j] != line[i+1] || slope[j]) return false;
                    slope[j] = true;
                }
            }
            //오르막 (뒤로 L칸 검사)
            else{
                for(int j=i;j>i-L;j--){
                    if(j<0 || line[j] != line[i] || slope[j]) return false;
                    slope[j] = true;
                }
            }

        }
        return true;
    }

}
