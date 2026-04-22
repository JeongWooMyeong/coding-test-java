package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 공유기설치4 {
    static int N, C;
    static int[] houses;
    static int answer=  0;

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

        int left = 1;
        int right = houses[N-1] - houses[0];

        while(left <= right){
            int mid = (left + right) / 2;
            if(canInstall(mid)){
                answer = mid;
                //거리를 더 늘려본다
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }


        System.out.println(answer);


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
