package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 배열돌리기1_3 {
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int minNum;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        minNum = Math.min(n, m);

        for(int i=1;i<=r;i++){
            rotate();
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }

    public static void rotate(){
        for(int i=0;i<minNum/2;i++){
            int x = i;
            int y = i;

            int temp = arr[x][y];

            int idx = 0;

            while(idx < 4){
                //왼쪽으로 넣는, 위로 넣는 , 오른쪽으로 넣는, 아래로 넣는 연산
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                //범위안이라면
                if(nx < arr.length-i && ny < arr[0].length-i && nx > i && ny >= i){
                    arr[x][y] = arr[nx][ny];
                    x = nx;
                    y = ny;
                }else{
                    idx++;
                }
            }

            arr[i+1][i] = temp;

        }
    }
}
