package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 공유기설치 {
    static int N, C;    //집 개수 N, 공유기 개수 C
    static int[] houses;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new int[N];
        for(int i=0;i<N;i++){
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int start = 1;  //최소 거리
        int end = houses[N - 1] - houses[0];    //최대 거리
        int result = 0;

        while(start <= end){
            int mid = (start + end) / 2;  //공유기 사이 최소 거리 후보
            if(canInstall(mid)){
                result = mid;   //설치 가능 -> 거리 늘려보기
                start = mid + 1;
            }else{
                end = mid - 1;  //설치 불가능 -> 거리 줄이기
            }
        }
        System.out.println(result);
    }

    //공유기를 최소 거리 dist 이상으로 설치할 수 있는지 확인
    static boolean canInstall(int dist){
        int count = 1;  //첫 집에는 무조건 설치
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
