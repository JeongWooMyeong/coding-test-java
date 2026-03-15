package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 사다리조작2 {
    static int n, m, h;
    static int[][] ladder;
    static int answer = 4;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   //세로선의 개수
        m = Integer.parseInt(st.nextToken());   //가로선의 개수
        h = Integer.parseInt(st.nextToken());   //세로선ㅁ다ㅏ 가로선을 놓을 수 있는 위치의 개수

        ladder = new int[h+1][n+1];

        //기존 가로선 입력
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = 1;
        }

        dfs(0, 1, 1);   //카운트, x, y

        System.out.print(answer >= 4 ? -1 : answer);

    }

    public static void dfs(int count, int x, int y){
        if(count >= answer) return;
        if(check()){
            answer = count;
            return;
        }
        //여기에 무슨 조건이 들어가야 할까?
        for(int i=x;i<=h;i++){
            for(int j=1;j<n;j++){
                //연속된 가로선이 올 수 없음
                if(ladder[i][j] == 0 && ladder[i][j-1] == 0 && ladder[i][j+1] == 0){
                    ladder[i][j] = 1;
                    dfs(count+1, i, j);
                    ladder[i][j] = 0;
                }
            }
        }


    }

    public static boolean check(){
        for(int i=1;i<n;i++){
            int pos = i;
            for(int j=1;j<=h;j++){
                if(ladder[j][pos] == 1) pos++;
                else if(pos > 1 && ladder[j][pos-1] == 1) pos--;
            }
            if(pos != i) return false;
        }

        return true;

    }

}
