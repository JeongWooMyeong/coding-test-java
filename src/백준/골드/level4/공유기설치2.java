package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 공유기설치2 {
    static int N, C;    //집의 개수 N 공유기 개수 C
    static int[] houses;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //집의 개수
        C = Integer.parseInt(st.nextToken()); //공유기 개수

        houses = new int[N];

        for(int i=0;i<N;i++){
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int start = 1;
        int end = houses[N-1] - houses[0];
        int result = 0;
        //공유기 설치 거리 기준
        while(start <= end){
            int mid = (start + end) / 2;
            if(canInstall(mid)){
                result = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(result);
    }

    static boolean canInstall(int dist){
        int count = 1; //첫번째 집
        int lastInstalled = houses[0];

        for(int i=1;i<N;i++){
            if(houses[i] - lastInstalled >= dist){
                count++;
                lastInstalled = houses[i];
            }
        }

        return count >= C;

    }
}
