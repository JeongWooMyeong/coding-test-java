package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 경사로2 {
    static int N, L;
    static int[][] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());   //경사로 길이

        arr= new int[N][N];
        //지도 정보 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        //행 검사
        for(int i=0;i<N;i++){
            int[] line = new int[N];
            for(int j=0;j<N;j++) line[j] = arr[i][j];
            if(canGo(line)) answer++;
        }

        //열 검사
        for(int j=0;j<N;j++){
            int[] line = new int[N];
            for(int i=0;i<N;i++) line[i] = arr[i][j];
            if(canGo(line)) answer++;
        }

        System.out.println(answer);
    }

    static boolean canGo(int[] arr){
        //경사로 판별
        boolean[] slope = new boolean[N];

        for(int i=0;i<N-1;i++){
            if(arr[i] == arr[i+1]) continue;
            //높이 차가 2 이상이면 불가능
            if(Math.abs(arr[i] - arr[i+1]) > 1) return false;
            //내리막
            if(arr[i] > arr[i+1]){
                for(int j=i+1;j<=i+L;j++){
                    if(j >= N || arr[j] != arr[i+1] || slope[j]) return false;
                    slope[j] = true;
                }
            }
            //오르막 (뒤로 L칸 검사)
            else{
                for(int j=i;j>=i-L+1;j--){
                    if(j<0 || arr[j] != arr[i] || slope[j]) return false;
                    slope[j] = true;
                }
            }


        }
        return true;
    }

}
