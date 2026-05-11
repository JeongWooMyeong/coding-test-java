package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 나무자르기 {
    static int n,m;
    static int[] wood;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        wood = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            wood[i] = Integer.parseInt(st.nextToken());
        }

        //나무 오름차순 정렬
        Arrays.sort(wood);

        int left = 0;
        int right = wood[n-1];
        int answer = Integer.MIN_VALUE;

        while(left <= right){
            int mid = (left + right) / 2;
            int sum = 0;
            for(int x : wood){
                if(x - mid > 0) {
                    sum += x - mid;
                }
            }
            //m보다 더 클때에는 절단기 높이 올림
            if(sum >= m){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        System.out.println(answer);
    }

}
