package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 공유기설치2 {

    static int N,C;
    static int[] house;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];

        for(int i=0;i<N;i++){
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int left = 1;
        int right = house[house.length-1];
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            int prev = house[0];
            int count = 1;

            for(int i=1;i<house.length;i++){
                //공유기 사이의 거리가 최소거리 이사이면 공유기 설치
                if(house[i] - prev >= mid){
                    count++;
                    //이전값 갱신
                    prev = house[i];
                }
            }
            //개수가 >= C이면 공유기 거리 증가
            if(count >= C){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        System.out.println(answer);

    }

}
