package 이것이코딩테스트다2.기출문제.그리디;

import java.util.*;
import java.io.*;

public class 무지의먹방라이브4 {
    static int N,K;
    static ArrayList<Food> list;
    static PriorityQueue<Food> pq = new PriorityQueue<>();

    static class Food implements Comparable<Food>{
        private int index;
        private int time;

        public Food(int index, int time){
            this.index = index;
            this.time = time;
        }

        public int getIndex(){
            return this.index;
        }

        public int getTime(){
            return this.time;
        }

        public int compareTo(Food other){
            return this.time - other.time;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int time = Integer.parseInt(st.nextToken());
            pq.offer(new Food(i+1, time));
        }


        int prevtime = 0;
        long sumtime = 0;
        int foodnum = N;
        while(!pq.isEmpty()){
            Food now = pq.peek();
            long diff = now.getTime() - prevtime;
            if(sumtime + diff * foodnum > K) break;
            sumtime += diff * foodnum;
            pq.poll();
            foodnum -= 1;
            prevtime = now.getTime();
        }

        if(pq.isEmpty()){
            System.out.println(-1);
        }else{
            list = new ArrayList<>(pq);
//            Collections.sort(list, Comparator.comparingInt(p -> p.index));
//            Collections.sort(list, (p1, p2) -> Integer.compare(p1.index, p2.index));
//            list.sort(Comparator.comparingInt((p1) -> p1.index));
            list.sort(Comparator.comparingInt(p1 -> p1.index));
            long idx = (K - sumtime) % foodnum;
            System.out.println(list.get((int)idx).getIndex());
        }

    }


}
