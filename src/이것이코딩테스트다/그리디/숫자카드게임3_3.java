package 이것이코딩테스트다.그리디;

import java.util.*;
import java.io.*;

public class 숫자카드게임3_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] tmp = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<M;j++){
                tmp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =0;i<N;i++){
            Arrays.sort(tmp[i]);
        }

        int max = tmp[0][0];
        int h = 0;

        for(int k=0;k<N;k++){
            if(max < tmp[k][0]){
                h = k;
            }
        }

        System.out.println(tmp[h][0]);




    }
}
