package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 공유기설치5 {

    static int N, C;
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

        int left = 0;
        int right = house[house.length-1];
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            if(can(mid)){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }


        System.out.println(answer);

    }

    static boolean can(int target){
        int prev = house[0];
        int count = 1;

        for(int x : house){
            if(x - prev >= target){
                count++;
                prev = x;
            }
        }

        return count >= C;
    }

}
