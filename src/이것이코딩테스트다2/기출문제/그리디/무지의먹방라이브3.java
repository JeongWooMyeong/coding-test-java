package 이것이코딩테스트다2.기출문제.그리디;

import java.util.*;
import java.io.*;

public class 무지의먹방라이브3 {
    static int N;   //음식의 개수
    static int K;   //네트워크 장애 발생 시간
    static ArrayList<Food> list = new ArrayList<>();

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

        PriorityQueue<Food> pq = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            int time = Integer.parseInt(st.nextToken());
            pq.offer(new Food(i+1, time));
        }

        long sumTime = 0;
        long prevTime = 0;

        while(!pq.isEmpty()){
            Food f = pq.peek();
            long diff = f.getTime() - prevTime;
            if(sumTime + diff * N > K) break;
            sumTime += diff * N;
            pq.poll();
            N--;
            prevTime = f.getTime();
        }

        if(pq.isEmpty()){
            System.out.println(-1);
        }else{
            List<Food> remain = new ArrayList<>(pq);
            //index 기준 오름차순 정렬
            remain.sort(Comparator.comparingInt(a -> a.index));
            long idx = (K - sumTime) % N;
            System.out.println(remain.get((int) idx).index);
        }
    }
}
