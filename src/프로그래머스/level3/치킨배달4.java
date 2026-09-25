package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 치킨배달4 {

    static int N,M;
    static List<int[]> house;
    static List<int[]> chicken;
    static int[][] map;
    //static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        answer = Integer.MAX_VALUE;
        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    chicken.add(new int[]{i,j});
                }else if(map[i][j] == 1){
                    house.add(new int[]{i,j});
                }
            }
        }

        //visited = new boolean[chicken.size()];

        dfs(0,new ArrayList<>(),0);

        System.out.println(answer);

    }


    static void dfs(int start, List<int[]> chickens, int count){

        if(count == M){
            answer = Math.min(answer, ChickenDist(chickens));
            return;
        }

        for(int i=start;i<chicken.size();i++){
            chickens.add(chicken.get(i));
            dfs(i+1, chickens, count+1);

            chickens.remove(chickens.size()-1);
        }
    }

    static int ChickenDist(List<int[]> chickens){
        int sum = 0;

        for(int[] h : house){
            int value = Integer.MAX_VALUE;
            for(int[] c : chickens){
                int dist = Math.abs(h[0]-c[0]) + Math.abs(h[1]-c[1]);
                value = Math.min(value, dist);
            }

            sum += value;
        }

        return sum;
    }

}
