package 삼성SW역량테스트.골드.level5;

import java.util.*;
import java.io.*;

public class 치킨배달 {
    static int N, M;
    static boolean[] selected;  //치킨집 선택
    static int result = Integer.MAX_VALUE;  //최솟값 결과
    static int[][] map;

    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> houses = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //NxN;
        M = Integer.parseInt(st.nextToken());   //치킨집 고를 경우의 수;

        //selected = new boolean[N];
        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) chickens.add(new int[]{i,j});
                if(map[i][j] == 1) houses.add(new int[]{i,j});
            }
        }
        //선택배열은 dfs 시작전에 해주는게 맞음 (백트래킹으로 원복하면서 진행하니)
        selected = new boolean[chickens.size()];

        //치킨집 선택 dfs
        dfs(0, 0);
        //치킨 거리 최솟값 출력
        System.out.println(result);


    }
    //치킨집 선택
    static void dfs(int idx, int count){
        if(count == M){
            result = Math.min(result, getChickenDistance());
            return;
        }

        if(idx == chickens.size()) return;

        //치킨집 선택
        selected[idx] = true;
        dfs(idx +1 , count + 1);
        //원복
        selected[idx] = false;

        //현재 치킨집 선택 x
        dfs(idx +1, count);


    }

    static int getChickenDistance(){
        int result = 0 ;
        for(int i=0;i<houses.size();i++){
            int dist = Integer.MAX_VALUE;
            int[] h = houses.get(i);
            for(int j=0;j<chickens.size();j++){
                if(selected[j]){
                    int[] c = chickens.get(j);
                    dist = Math.min(dist, Math.abs(h[0]-c[0]) + Math.abs(h[1]-c[1]));
                }
            }
            result += dist;
        }

        return result;
    }


}

