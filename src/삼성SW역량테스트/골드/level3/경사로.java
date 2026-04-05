package 삼성SW역량테스트.골드.level3;

import java.util.*;
import java.io.*;

public class 경사로 {
    static int N, L;
    static int[][] map;
    static int result = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //행검사
        for(int i=0;i<N;i++){
            if(check(map[i])) result++;
        }

        //열검사
        for(int j=0;j<N;j++){
            int[] col = new int[N];
            for(int i=0;i<N;i++) col[i] = map[i][j];
            if(check(col)) result++;
        }

        System.out.println(result);

    }

    static boolean check(int[] line){
        boolean[] slope = new boolean[N];
        for(int i=0;i<N-1;i++){
            if(line[i] == line[i+1]) continue;  //높이 같으면 통과
            else if(line[i] + 1 == line[i+1]){
                //오르막
                for(int j=i;j>i-L;j--){
                    if(j < 0 || line[j] != line[i] || slope[j]) return false;
                    slope[j] = true;
                }
            }
            else if(line[i] - 1 == line[i+1]){
                for(int j=i+1;j<=i+L;j++){
                    if(j >= N || line[j] != line[i+1] || slope[j]) return false;
                    slope[j] = true;
                }
            }
            else return false;  //높이 차이가 2 이상이면 불가능


        }
        return true;
    }

}
