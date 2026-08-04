package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 치킨배달3 {

    static int N,M;
    static List<int[]> chicken;
    static List<int[]> house;
    static int[][] board;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        chicken = new ArrayList<>();
        house = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) house.add(new int[]{i,j});
                if(board[i][j] == 2) chicken.add(new int[]{i,j});
            }
        }

        answer = Integer.MAX_VALUE;
        visited = new boolean[chicken.size()];
        dfs(0, new ArrayList<>(), M);

        System.out.println(answer);
    }

    static void dfs(int start, List<Integer> list, int target){

        if(list.size() == target){
            answer = Math.min(answer, chickenDistance(list));
            return;
        }

        for(int i=start;i<chicken.size();i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(i);
                dfs(i+1, list, target);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }

    }

    static int chickenDistance(List<Integer> list){

        int distance = 0;

        for(int i=0;i<house.size();i++){
            int[] h = house.get(i);
            int minValue = Integer.MAX_VALUE;

            for(int j=0;j<list.size();j++){
                int idx = list.get(j);
                int[] c = chicken.get(idx);
                int diff = Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]);

                minValue = Math.min(minValue, diff);
            }

            distance += minValue;
        }

        return distance;
    }

}
