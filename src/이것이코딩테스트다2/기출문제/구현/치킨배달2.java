package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

public class 치킨배달2 {
    static int N, M;
    static ArrayList<int[]> chickens = new ArrayList<>();
    static ArrayList<int[]> houses = new ArrayList<>();
    static boolean[] selected;  //치킨집 선택 / 안한다
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int val = Integer.parseInt(st.nextToken());

                if(val == 1) houses.add(new int[]{i,j});
                else if(val == 2) chickens.add(new int[]{i,j});
            }
        }

        selected = new boolean[chickens.size()];    //치킨집 선택이므로 치킨집 사이즈 만큼 배열 초가화
        dfs(0, 0);  //idx, 치킨집 개수 (M이 주어졌으므로)

        System.out.print(result);
    }

    static void dfs(int idx, int count){
        if(count == M){
            //치킨집 개수가 도달했으며(0
            result = Math.min(result, getCityDistance());
            return;
        }
        if(idx == chickens.size()) return;

        //백트래킹 현재 치킨집 서택
        selected[idx] = true;
        dfs(idx + 1,  count + 1);
        //현재 치킨집 미선택
        selected[idx] = false;
        dfs(idx + 1, count);

    }

    static int getCityDistance(){
        //치킨 거리의 합
        int sum = 0;
        for(int[] h : houses){
            //치킨 거리
            int dist = Integer.MAX_VALUE;
            for(int i=0;i<chickens.size();i++){
                if(selected[i]) {
                    int[] c = chickens.get(i);
                    dist = Math.min(dist, Math.abs(h[0]-c[0]) + Math.abs(h[1]-c[1]));
                }

            }
            sum += dist;
        }
        return sum;
    }

}
