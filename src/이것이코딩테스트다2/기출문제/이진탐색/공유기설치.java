package 이것이코딩테스트다2.기출문제.이진탐색;

import java.util.*;
import java.io.*;

public class 공유기설치 {
    static int N, C;    //집 개수 N 공유기 개수 C
    static int[] houses;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        houses = new int[N];

        //1. 집 정보 입력
        for(int i=0;i<N;i++){
            houses[i] = Integer.parseInt(br.readLine());
        }
        //2. 집 오름차순으로 정렬
        Arrays.sort(houses);

        //3. 집의 최소 최대 거리 측정
        int low = houses[0];
        int high = houses[houses.length-1] - houses[0];

        int result = 0;
        while(low<=high){
            int mid = (low + high) / 2;
            //공유기 설치 가능하면
            if(canInstall(houses, C, mid)){
                result = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        System.out.print(result);

    }

    static boolean canInstall(int[] houses, int C, int dist){
        int count = 1;
        int last = houses[0];

        for(int i=1;i<houses.length;i++){
            if(houses[i] - last >= dist){
                count++;
                last = houses[i];
            }
        }

        return count >= C;

    }

}
