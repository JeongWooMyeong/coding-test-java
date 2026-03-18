package 백준.실버.level2;

import java.util.*;
import java.io.*;

public class 가장긴증가하는부분수열3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //LIS 후보 배열
        ArrayList<Integer> lis = new ArrayList<>();

        for(int num : arr){
            //이분 탐색으로 위치 찾기
            int pos = Collections.binarySearch(lis, num);
            if(pos < 0 ) pos = -(pos + 1);  //삽입 위치
            
            if(pos == lis.size()){
                lis.add(num);   //뒤에 추가
            }else{
                lis.set(pos, num);  //교체
            }
        }

        System.out.println(lis.size());
    }

}
