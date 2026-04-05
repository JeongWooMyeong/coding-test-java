package 삼성SW역량테스트.실버.level1;

import java.util.*;
import java.io.*;

public class 스타트와링크 {
    static int N;
    static int[][] team;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        team = new int[N][N];

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];

        dfs(0, 0);

        System.out.print(result);


    }

    //dfs 팀 선택
    static void dfs(int idx, int count){
        if(count == (N/2)){
            calculate();
            return;
        }
        if(idx == N) return;

        //현재 팀 선택
        visited[idx] = true;
        dfs(idx+1, count+1);
        visited[idx] = false;

        //현재 팀 선택안함
        dfs(idx+1, count);

    }

    static void calculate(){
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(visited[i] && visited[j]){
                    sum1 += team[i][j] + team[j][i];
                    //break;
                }
                else if(!visited[i] && !visited[j]){
                    sum2 += team[i][j] + team[j][i];
                    //break;
                }
            }
        }

        result = Math.min(Math.abs(sum1 - sum2), result);
    }


}
