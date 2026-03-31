package 이것이코딩테스트다2.기출문제.이진탐색;

import java.util.*;
import java.io.*;

public class 공유기설치2 {
    static int N, C;
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

        int low = 1;
        int high = houses[N-1] - houses[0];
        int result = 0;

        while(low <= high){
            int mid = (low + high) / 2;
            if(canInstall(mid, C, houses)){
                result = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        System.out.print(result);

    }

    static boolean canInstall(int mid, int C, int[] houses){
        int count = 1;
        int last = houses[0];
        for(int i=1;i<N;i++){
            if(houses[i] - last >= mid){
                count++;
                last = houses[i];
            }
        }

        return count >= C;
    }

}
