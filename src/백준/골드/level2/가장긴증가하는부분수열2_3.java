package 백준.골드.level2;

import java.util.*;
import java.io.*;

/*
크기 N 1 ~ 1,000,000
범위가 크기 떄문에
이진탐색으로 list 넣어서 길이 구해줌

 */

public class 가장긴증가하는부분수열2_3 {
    static int N;
    static int[] map;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            int pos = lowerBound(map[i], list);
            if(pos == list.size()){
                list.add(map[i]);
            }else{
                list.set(pos, map[i]);
            }
        }


        System.out.println(list.size());


    }

    static int lowerBound(int value, List<Integer> list){
        int start = 0; int end = list.size();
        while(start < end){
            int mid = (start + end) / 2;
            if(list.get(mid) < value) start = mid + 1;
            else end = mid;
        }

        return start;
    }

}
