package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 공유기설치 {
    static int[] house;
    static int n,c;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   //집의 개수
        c = Integer.parseInt(st.nextToken());   //공유기 설치 개수

        house = new int[n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            house[i] = Integer.parseInt(st.nextToken());
        }

        //집 오름차순 정렬
        Arrays.sort(house);

        int left= 1;
        int right = house[house.length-1] - house[0];
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;   //집 사이 설치 최소거리
            int prev = house[0];
            int count = 1;

            for(int i=1;i<house.length;i++){
                int diff = house[i] - prev;
                if(diff >= mid) {
                    count++;
                    prev = house[i];
                }
            }
            //공유기 설치개수가 설치해야하는 개수보다 적거나 같으면
            if(count >= c){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        System.out.println(answer);
    }

}
