package 삼성SW역량테스트.골드.level3;

import java.util.*;
import java.io.*;

public class 경사로2 {
    static int N, L;
    static int[][] map;
    static int result = 0;

    public static void main(String[] args) throws Exception{
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

        //열 검사
        for(int j=0;j<N;j++){
            int[] col = new int[N];
            for(int i=0;i<N;i++){
                col[i] = map[i][j];
            }

            if(check(col)) result++;

        }


        System.out.print(result);

    }

    static boolean check(int[] line){
        boolean[] slope = new boolean[N];

        for(int i=0;i<N-1;i++){
            if(line[i] == line[i+1]) continue;
            //오르막
            else if(line[i] + 1 == line[i+1]){
                //이전 비교
                for(int j=i;j>i-L;j--){
                    //범위를 벗어나거나, 이전이랑 같은 값이 아니거나, 이전에 경사로가 있으면
                    if(j < 0 || line[i] != line[j] || slope[j]) return false;
                    slope[j] = true;
                }
            //내리막
            }else if(line[i] - 1 == line[i+1]){
                for(int j=i+1;j<=i+L;j++){
                    if(j >= N || line[j] != line[i+1] || slope[j]) return false;
                    slope[j] = true;
                }
            }else return false; //높이 2차이 나면 false
        }

        return true;
    }

}
