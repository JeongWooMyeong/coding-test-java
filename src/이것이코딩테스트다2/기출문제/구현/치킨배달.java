package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

public class 치킨배달 {
    static int N, M;
    static ArrayList<int[]> chickens = new ArrayList<>();
    static ArrayList<int[]> houses = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static boolean[] selected;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //도시의 개수
        M = Integer.parseInt(st.nextToken());   //최대 치킨집 개수

        //치킨집, 가정집 value에 따라 담기
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int val = Integer.parseInt(st.nextToken());
                if(val == 1) houses.add(new int[]{i, j});
                else if(val == 2) chickens.add(new int[]{i,j});
            }
        }

        selected = new boolean[chickens.size()];

        dfs(0,0);


        System.out.println(result);

    }

    static void dfs(int idx, int count){
        if(count == M){
            result = Math.min(result, getCityChickenDistance());
            return;
        }
        if(chickens.size() == idx) return;

        //현재 치킨집 선택
        selected[idx] = true;
        dfs(idx+1, count+1);
        //선택안함
        selected[idx] = false;
        dfs(idx+1, count);


    }

    static int getCityChickenDistance(){
        int sum = 0;
        for(int[] h : houses){
            int dist = Integer.MAX_VALUE;
            for(int i=0;i<chickens.size();i++){
                if(selected[i]) {
                    int[] c = chickens.get(i);
                    dist = Math.min(dist, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
                }
            }
            sum += dist;
        }

        return sum;

    }

}
