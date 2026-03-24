package 백준.실버.level2;

import java.util.*;
import java.io.*;

public class 가장긴증가하는부분수열5 {
    static int N;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        //int end = list.size();

        for(int i=0;i<N;i++){
            int pos = binarySearch(start, list.size(), arr[i]);
            if(list.size() == pos){
                list.add(arr[i]);
            }else{
                list.set(pos, arr[i]);
            }
        }


        System.out.print(list.size());


    }

    static int binarySearch(int start, int end, int value){

        while(start < end){
            int pos = (start + end) / 2;
            if(list.get(pos) < value){
                start = pos + 1;
            }else{
                end = pos;
            }
        }

        return start;
    }

}
