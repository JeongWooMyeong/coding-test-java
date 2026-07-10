package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 치킨배달 {

    static int N,M;
    static List<int[]> chicken;
    static List<int[]> houses;
    static int[][] board;
    static int answer;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = Integer.MAX_VALUE;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        chicken = new ArrayList<>();
        houses = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2){
                    chicken.add(new int[]{i,j});
                }else if(board[i][j] == 1){
                    houses.add(new int[]{i,j});
                }
            }
        }

        visited = new boolean[chicken.size()];
        dfs(0, new ArrayList<>());


        System.out.println(answer);
    }

    static void dfs(int idx, List<int[]> list){
        if(list.size() == M){

            int sum = 0;

            for(int i=0;i<houses.size();i++){
                int[] h = houses.get(i);
                int minValue = Integer.MAX_VALUE;
                for(int j=0;j<list.size();j++){
                    int[] c = list.get(j);

                    int diff = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    minValue = Math.min(minValue, diff);
                }

                sum += minValue;

            }

            answer = Math.min(answer, sum);
            return;
        }

        for(int i=idx;i<chicken.size();i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(chicken.get(i));
                dfs(i+1, list);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }

    }

}
