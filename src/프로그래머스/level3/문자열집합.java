package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 문자열집합 {

    static int N,M;
    static List<String> list;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for(int i=0;i<N;i++){
            list.add(br.readLine());
        }

        Collections.sort(list);

        for(int i=0;i<M;i++){
            String target = br.readLine();

            boolean found = binarySearch(target, list);

            if(found) answer++;
        }

        System.out.println(answer);

    }

    static boolean binarySearch(String target, List<String> list){
        int left = 0;
        int right = list.size()-1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(list.get(mid).equals(target)) return true;

            if(list.get(mid).compareTo(target) < 0){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        return false;
    }

}
