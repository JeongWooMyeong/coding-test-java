package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 공유기설치3 {
    static int N, C;
    static int[] houses;
    static int result = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //집의 개수
        C = Integer.parseInt(st.nextToken());   //공유기 개수

        houses = new int[N];

        for(int i=0;i<N;i++){
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int start = 1;
        int end = houses[N-1] - houses[0];

        while(start <= end){
            int mid = (start + end) / 2;

            if(canInstall(mid)){
                result = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }

        }

        System.out.print(result);



    }

    static boolean canInstall(int dist){
        int count = 1;
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
