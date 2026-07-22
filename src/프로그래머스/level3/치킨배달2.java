package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 치킨배달2 {

    static int N,M;
    static int[][] board;
    static ArrayList<int[]> chicken;
    static ArrayList<int[]> house;
    static int answer;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        answer = Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2) chicken.add(new int[]{i,j});
                if(board[i][j] == 1) house.add(new int[]{i,j});
            }
        }

        visited = new boolean[chicken.size()];
        dfs(0, new ArrayList<>());


        System.out.println(answer);

    }

    static void dfs(int start, List<Integer> list){
        if(list.size() == M){
            //System.out.println("ㄴㅇㄹㄴㅇㄹ");
            answer = Math.min(answer, chickenDist(list));
            return;
        }

        for(int i=start;i<chicken.size();i++){
            list.add(i);
            dfs(i+1,list);
            list.remove(list.size()-1);
        }

    }

    static int chickenDist(List<Integer> list){
        int result = 0;
            for(int[] h : house){
                int x2 = h[0];
                int y2 = h[1];
                int minValue = Integer.MAX_VALUE;
                for(int idx : list) {
                    int x1 = chicken.get(idx)[0];
                    int y1 = chicken.get(idx)[1];

                    minValue = Math.min(minValue, Math.abs(x2 - x1) + Math.abs(y2 - y1));
                }
                result += minValue;

            }

        return result;
    }

}
