package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 수찾기 {
    static int[] num;
    static int[] answer;
    static int n,m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        //num 오름차순 정렬 (이진탐색 필수)
        Arrays.sort(num);

        m = Integer.parseInt(br.readLine());
        answer = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int findNum = Integer.parseInt(st.nextToken());
            answer[i] = binarySearch(findNum);
        }

        StringBuilder sb = new StringBuilder();
        for(int x : answer){
            sb.append(x).append("\n");
        }

        System.out.println(sb.toString());
    }


    static int binarySearch(int target){
        int left = 0; int right = num.length-1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(num[mid] == target) return 1;
            // == 이 있어서 붙일 필요 없음
            if(num[mid] > target){
                right = mid -1;
            }else{
                left = mid + 1;
            }

        }

        return 0;
    }


}
