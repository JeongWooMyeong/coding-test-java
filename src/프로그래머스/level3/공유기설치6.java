package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 공유기설치6 {

    static int N, C;
    static int[] house;
    static long answer;

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

        long left = 0;
        long right = house[house.length-1];

        while(left <= right){
            long mid = (left + right) / 2;

            if(can(mid)){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        System.out.println(answer);
    }

    static boolean can(long target){
        long prev = house[0];
        long count = 1;
        for(int i=1;i<house.length;i++){
            if(house[i] - prev >= target){
                count++;
                prev = house[i];
            }
        }

        return count >= C;
    }

}
