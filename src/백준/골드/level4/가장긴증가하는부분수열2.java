package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 가장긴증가하는부분수열2 {
    static int N;
    static int[] arr;
    static int[] pos;   //각 원소가 들어간 위치 기록
    static int[] prev;  //이전 인덱스 추적

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        pos = new int[N];
        prev = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            prev[i] = -1;   //초기값 앞에 연결된 원소 없음
        }

        List<Integer> lis = new ArrayList<>();
        List<Integer> idx = new ArrayList<>();  //lis에 들어간 인덱스 기록

        for(int i=0;i<N;i++){
            int x = arr[i];
            int p =lowerBound(lis, x);
            if(p == lis.size()){
                lis.add(x);
                idx.add(i);
            }else{
                lis.set(p, x);
                idx.set(p, i);
            }
            pos[i] = p;
            if(p > 0) prev[i] = idx.get(p-1);
        }

        //LIS 길이 출력
        System.out.println(lis.size());

        //역추적 (ArrayDeque 사용)
        int last = idx.get(lis.size()-1);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        while(last != -1){
            deque.addFirst(arr[last]);
            last = prev[last];
        }

        //출력
        for(int x : deque){
            System.out.print(x + " ");
        }
    }

    static int lowerBound(List<Integer> list, int key){
        int left = 0, right = list.size();
        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) < key) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
